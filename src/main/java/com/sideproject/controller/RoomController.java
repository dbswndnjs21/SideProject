package com.sideproject.controller;

import com.sideproject.dto.RoomDto;
import com.sideproject.dto.RoomRequest;
import com.sideproject.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    // 방 생성 (참여자 목록을 받음)
    @PostMapping
    public RoomDto createRoom(@RequestBody RoomRequest roomRequest) {
        System.out.println("Rooms에서 받은 reqeust : " + roomRequest.getParticipants()); // user2면 9 나옴
        RoomDto roomDto = roomService.createRoom(roomRequest);
        return roomDto;
    }
}
