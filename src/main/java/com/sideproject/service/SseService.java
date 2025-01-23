package com.sideproject.service;

import com.sideproject.dto.NotificationDto;
import com.sideproject.repository.EmitterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class SseService {
    private static final Long DEFAULT_TIMEOUT = 60L * 1000 * 60; // timeout 1시간 설정
    private final EmitterRepository emitterRepository;

    // SSE 연결을 위해서 필요한 메서드 : 구독
    public SseEmitter subscribe(Long userId) {
        SseEmitter emitter = new SseEmitter(DEFAULT_TIMEOUT);
        // TODO: 데이터 유실 시점 파악을 위해 emitter에 추가하기
        //데이터 유실 시점 파악을 위해 id 변수에 담기
        String id = userId + "_" + System.currentTimeMillis();
        emitterRepository.save(userId, emitter);

        // emitter 완료 -> emitter 삭제
        emitter.onCompletion(() -> emitterRepository.deleteById(userId));
        // emitter 타임아웃(이벤트 전송 X) -> emitter 삭제
        emitter.onTimeout(() -> emitterRepository.deleteById(userId));

        try{
            emitter.send(SseEmitter.event()
                    .name("connect")
                    .data("connedted"));
            emitterRepository.save(userId, emitter);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
        log.info("SSE subscribe: {}", emitterRepository.get(userId));
        return emitter;
    }

    public void sendNotification(Long userId, String message) {
        // 클라이언트의 emitter를 받아온다
        SseEmitter emitter = emitterRepository.get(userId);
        log.info("SSE: {}", emitter);
        if (emitter != null) {
            try {
                emitter.send(SseEmitter.event().data(message));
                log.info("message: {}", message);
            } catch (Exception e) {
                // 실패한 경우
                emitterRepository.deleteById(userId);
            }
        }
    }
}