//package com.sideproject.controller;
//
//import com.sideproject.service.SseService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
//
//@Slf4j
//@Controller
//@RequiredArgsConstructor
//public class NotificationController {
//    private final SseService sseService;
//
//    // 클라이언트와 연결
//    @GetMapping(value = "/notification/{userId}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
//    public SseEmitter subscribe(@PathVariable("userId") Long userId) {
//        log.info("subscribe -> {}", userId);
//        SseEmitter emitter = sseService.subscribe(userId);
//        return emitter;
//    }
//}
