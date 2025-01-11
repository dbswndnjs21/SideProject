package com.sideproject.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RequiredArgsConstructor
public class NotificationRepository {
    private final Map<Long, SseEmitter> emitters = new ConcurrentHashMap<>();

    // 클라이언트에게 보낼 id와 데이터를 저장
    public void save(Long userId, SseEmitter emitter) {
        emitters.put(userId, emitter);
    }

    // emitter가 완료될때, 타임아웃 되었을 때, 오류가 발생했을 때 사용
    public void deleteById(Long userId) {
        emitters.remove(userId);
    }

    // 정보를 담기 위해 클라이언트(id)의 emitter를 가져오기
    public SseEmitter get(Long userId) {
        return emitters.get(userId);
    }
}
