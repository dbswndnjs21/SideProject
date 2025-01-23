package com.sideproject.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@RequiredArgsConstructor
public class EmitterRepository {
    private final Map<String, SseEmitter> emitters = new ConcurrentHashMap<>();

    // 클라이언트에게 보낼 id와 데이터를 저장
    // String id = userId + "_" + System.currentTimeMillis();
    public void save(String id, SseEmitter emitter) {
        emitters.put(id, emitter);
    }

    // emitter가 완료될때, 타임아웃 되었을 때, 오류가 발생했을 때 사용
    public void deleteById(String id) {
        emitters.remove(id);
    }

    // 정보를 담기 위해 클라이언트(id)의 emitter를 가져오기
    public SseEmitter get(String id) {
        return emitters.get(id);
    }
}
