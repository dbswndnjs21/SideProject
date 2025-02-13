package com.sideproject.dto;

import com.sideproject.entity.UserEntity;

import java.util.List;

public class RoomDto {
    private Long id;
    private List<UserEntity> participants;

    public RoomDto(Long id, List<UserEntity> participants) {
        this.id = id;
        this.participants = participants;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<UserEntity> getParticipants() {
        return participants;
    }

    public void setParticipants(List<UserEntity> participants) {
        this.participants = participants;
    }
}
