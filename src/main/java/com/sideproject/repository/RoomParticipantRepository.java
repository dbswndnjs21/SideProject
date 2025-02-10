package com.sideproject.repository;

import com.sideproject.entity.RoomParticipant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomParticipantRepository extends JpaRepository<RoomParticipant, Long> {

    List<RoomParticipant> findByUserId(Long userId);

}
