package com.sideproject.service;

import com.sideproject.repository.RefreshRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class TokenCleanupScheduler {

    private final RefreshRepository refreshRepository;

    @Scheduled(cron = "0 0 0 * * *") // 매일 자정에 실행
//    @Scheduled(cron = "*/10 * * * * *")
    public void cleanUpExpiredTokens() {
        // 현재 날짜
        String currentDate = new Date().toString();

        // 만료된 토큰 삭제
        refreshRepository.deleteExpiredTokens(currentDate);

        System.out.println("Expired tokens deleted at: " + currentDate);
    }
}