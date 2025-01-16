package com.sideproject.dto;

import com.sideproject.entity.Room;
import com.sideproject.entity.RoomParticipant;
import com.sideproject.entity.UserEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomParticipantDto {

    private Long id; // RoomParticipant의 ID
    private Long roomId; // Room의 ID
    private Long userId; // UserEntity의 ID

    // 기본 생성자
    public RoomParticipantDto() {}


    // 엔티티 → DTO 변환용 생성자
    public RoomParticipantDto(RoomParticipant roomParticipant) {
        this.id = roomParticipant.getId();
        this.roomId = roomParticipant.getRoom().getId();
        this.userId = roomParticipant.getUser().getId();
    }

    // DTO → 엔티티 변환 메서드 (빌더 사용)
    public RoomParticipant toEntity(Room room, UserEntity user) {
        return RoomParticipant.builder()
                .id(this.id)
                .room(room)
                .user(user)
                .build();
    }
}
