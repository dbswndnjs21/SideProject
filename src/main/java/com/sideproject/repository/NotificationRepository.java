package com.sideproject.repository;

import com.sideproject.dto.NotificationDto;
import com.sideproject.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long>, NotificationCustomRepository {
    Long likedYourPost(Long userId, Long studyBoardId);
}
