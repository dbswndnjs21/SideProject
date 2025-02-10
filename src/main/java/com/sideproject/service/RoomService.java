package com.sideproject.service;

import com.sideproject.dto.RoomDto;
import com.sideproject.dto.RoomRequest;
import com.sideproject.entity.Room;
import com.sideproject.entity.RoomParticipant;
import com.sideproject.entity.UserEntity;
import com.sideproject.repository.RoomRepository;
import com.sideproject.repository.UserRepository;
import com.sideproject.repository.RoomParticipantRepository;
import org.apache.tomcat.util.descriptor.web.ContextHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoomParticipantRepository roomParticipantRepository; // RoomParticipantRepository 추가

    // 방 생성
    public RoomDto createRoom(RoomRequest roomRequest) {
        // 사용자 목록을 받아서 방에 참여자 추가
        List<UserEntity> participants = userRepository.findAllById(roomRequest.getParticipants());
        System.out.println(" 방 참가자 : " + participants);

        // 방 생성
        Room room = new Room();
        room = roomRepository.save(room); // 방 저장 후 ID를 얻기

        // 참가자들과의 관계를 RoomParticipant로 설정
        for (UserEntity participant : participants) {
            RoomParticipant roomParticipant = new RoomParticipant();
            roomParticipant.setRoom(room); // 방 설정
            roomParticipant.setUser(participant); // 사용자 설정
            roomParticipantRepository.save(roomParticipant); // RoomParticipant 저장

            // UserEntity에 해당 RoomParticipant 정보 추가
            participant.getRoomParticipants().add(roomParticipant);
            userRepository.save(participant); // UserEntity 저장
            // 본인도 같은 roomid에 저장해야함
            RoomParticipant roomParticipant2 = new RoomParticipant();
            roomParticipant2.setRoom(room);
            String name = SecurityContextHolder.getContext().getAuthentication().getName();
            UserEntity byUsername = userRepository.findByUsername(name);
            roomParticipant2.setUser(byUsername);
            roomParticipantRepository.save(roomParticipant2);

        }

        // 생성된 방의 id와 참가자 목록 반환
        return new RoomDto(room.getId(), participants);
    }
}
