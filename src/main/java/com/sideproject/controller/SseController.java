package com.sideproject.controller;

import com.sideproject.service.SseService;
import com.sideproject.service.UserService;
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
    private final UserService userService;

    // SSE 연결하기 위해 subscribe 공통 메서드
    @GetMapping(value = "/notification/{userId}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
//    public SseEmitter notification(@PathVariable("username") String username) {
    public SseEmitter notification(String username) {
        // TODO: last id 추가해서 클라이언트가 미수신한 Event 유실 예방
        // TODO: 좋아요 클릭시 글 작성자에 대한 emitter 열어주는 거 어디에 추가할 지 고민, 여기에 추가하면 SRP 위반
        // 로그인시 username으로 담겨있어서 userId로 변환
        Long userId = userService.getUserIdfromUsername(username);

        // TODO: jwt연결 전 test용 test 이후에 삭제하기
        if(userId == null){
            userId = 1L;
        }

        return sseService.subscribe(userId);
    }
}
