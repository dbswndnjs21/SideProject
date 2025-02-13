package com.sideproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecentViewService {
    private final UserService userService;

    private final String USER_RECENT_VIEW = "user_recent_view";
    private final long SECONDS_IN_A_DAY = 24L * 60 * 60;

    private final RedisTemplate<String, Object> redisTemplate;

    // 사용자의 아이템 ID와 조회시간을 저장
    public void addPostRecentView(String username, Long itemId) {
        String userKey = getUserViewKey(username);
        double score = getCurrentTimeInSeconds(); // 현재시간을 같이 저장해서 정렬할 수 있게 함
        redisTemplate.opsForZSet().add(userKey, String.valueOf(itemId), score); // oopsForZSet = Sroted Set: 중복이 제거된 List
    }

    // 최근 일주일 조회
    public Set<Long> getViewsData(String username, int count) {
        String userKey = getUserViewKey(username);
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
    public String getUserViewKey(String username) {
        return String.format(USER_RECENT_VIEW, username);
    }

    // 현재 시간을 밀리초에서 초 단위로 변환
    private double getCurrentTimeInSeconds() {
        return System.currentTimeMillis() / 1000.0;
    }

}
