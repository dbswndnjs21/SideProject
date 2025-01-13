package com.sideproject.controller;

import com.sideproject.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Controller
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;

    // 클라이언트와 연결
    @GetMapping(value = "/notification/{userId}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter subscribe(@PathVariable("userId") Long userId) {
        System.out.println(userId);
        SseEmitter emitter = notificationService.subscribe(userId);
        return emitter;
    }
}
