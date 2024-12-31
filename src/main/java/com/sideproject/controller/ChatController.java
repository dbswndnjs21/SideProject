package com.sideproject.controller;

import com.sideproject.dto.ChatRoom;
import com.sideproject.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;

    @GetMapping("/chat/chatList")
    public List<ChatRoom> chatList() {
        return chatService.findAllRoom();
    }

    @PostMapping("/chat/createRoom")
    public ChatRoom createRoom(@RequestParam String name) {
        return chatService.createRoom(name);
    }

    @GetMapping("/chat/chatRoom")
    public ChatRoom chatRoom(@RequestParam String roomId) {
        return chatService.findRoomById(roomId);
    }
}
