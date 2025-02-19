package com.sideproject.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class RecentViewService {
    private final UserService userService;

    private static final String USER_RECENT_VIEW = "user:%s:view_items";
    private final long SECONDS_IN_A_DAY = 24L * 60 * 60;

    private final RedisTemplate<String, Object> redisTemplate;

    // 사용자의 아이템 ID와 조회시간을 저장
    public void addPostRecentView(Long userId, Long itemId) {
//        Long userId = userService.getUserIdByUsername(username);
        String userKey = getUserViewKey(userId);
        double score = getCurrentTimeInSeconds(); // 현재시간을 같이 저장해서 정렬할 수 있게 함
        log.info("getUserViewKey: {}", userKey);
        redisTemplate.opsForZSet().add(userKey, String.valueOf(itemId), score); // oopsForZSet = Sroted Set: 중복이 제거된 List
        redisTemplate.expire(userKey, 7, TimeUnit.DAYS); // 7일간만 저장하도록 TTL 설정
    }

    // 최근 일주일 조회
    public Set<Long> getViewsData(Long userId, int count) {
//        Long userId = userService.getUserIdByUsername(username);
        String userKey = getUserViewKey(userId);
        double minScore = getCurrentTimeInSeconds() - SECONDS_IN_A_DAY;
        return convertSet(redisTemplate.opsForZSet().reverseRangeByScore(userKey, minScore, Double.MAX_VALUE, 0, count));
    }

    public Set<Long> convertSet(Set<Object> itemIds) { // Object 타입을 long으로 변환하는 과정
        if (itemIds == null) return new LinkedHashSet<>();

        return itemIds.stream()
                .map(itemId -> Long.parseLong((String) itemId))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    // userId로 고유한 redis key 값을 생성
    public String getUserViewKey(Long userId) {
        return String.format(USER_RECENT_VIEW, userId);
    }

    // 현재 시간을 밀리초에서 초 단위로 변환
    private double getCurrentTimeInSeconds() {
        return System.currentTimeMillis() / 1000.0;
    }

}
