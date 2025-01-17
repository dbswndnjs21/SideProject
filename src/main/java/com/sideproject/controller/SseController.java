package com.sideproject.controller;

import com.sideproject.service.SseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequestMapping("/sse")
@RequiredArgsConstructor
public class SseController {
    private final SseService sseService;

    // subscribe하는 공통 메서드
    @GetMapping(value = "/notification/{userId}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
//    public SseEmitter notificationLike(@PathVariable("userId") Long userId) {
    public SseEmitter notificationLike(Long userId) {
        if(userId == null){
            userId = 1L;
        }
        return sseService.subscribe(userId);
    }

    // 데이터 전송 API
    // 좋아요 알림 to 작성자
    @GetMapping("/notification/liked/{userId}")
    public void sendLiked(@PathVariable("userId") Long userId) {

    }
}
