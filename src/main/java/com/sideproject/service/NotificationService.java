package com.sideproject.service;

import com.sideproject.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RequiredArgsConstructor
public class NotificationService {
    private static final Long DEFAULT_TIMEOUT = 60L * 1000 * 60; // timeout 1시간 설정
    private final NotificationRepository notificationRepository;

    private SseEmitter createEmitter(Long userId) {
        SseEmitter emitter = new SseEmitter(DEFAULT_TIMEOUT);
        notificationRepository.save(userId, emitter);

        // emitter 완료 -> emitter 삭제
        emitter.onCompletion(() -> notificationRepository.deleteById(userId));
        // emitter 타임아웃(이벤트 전송 X) -> emitter 삭제
        emitter.onTimeout(() -> notificationRepository.deleteById(userId));

        return emitter;
    }
}
