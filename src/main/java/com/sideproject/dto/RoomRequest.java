package com.sideproject.dto;

import java.util.List;

public class RoomRequest {
    private List<Long> participants;

    public List<Long> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Long> participants) {
        this.participants = participants;
    }
}
