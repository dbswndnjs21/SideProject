package com.sideproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecentViewService {
    private final UserService userService;

    private final String USER_RECENT_VIEW = "user_recent_view";
    private final long SECONDS_IN_A_DAY = 24L * 60 * 60;

    private final RedisTemplate<String, String> redisTemplate;

    // 사용자의 아이템 ID와 조회시간을 저장
    public void addPostRecentView(String username, Long studyBoardId) {
        String userKey = getUserViewKey(username);
        double score = getCurrentTimeInSeconds();
        redisTemplate.opsForZSet().add(userKey, String.valueOf(studyBoardId), score);

    }

    // userId로 고유한 redis key 값을 생성
    public String getUserViewKey(String username) {
        // 우리는 유저 정보에 username을 담았기때문에 userId 찾아주는 부분이 필요
        Long userId = userService.getUserIdByUsername(username);
        return String.format(USER_RECENT_VIEW, userId);
    }

    // 현재 시간을 밀리초에서 초 단위로 변환
    private double getCurrentTimeInSeconds() {
        return System.currentTimeMillis() / 1000.0;
    }

}
