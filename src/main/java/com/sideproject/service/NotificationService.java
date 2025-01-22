package com.sideproject.service;

import com.sideproject.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public Long updateLikedToWriterNotification(String username, Long studyBoardId) {
        return notificationRepository.likedYourPost(username, studyBoardId);
    }

    public Long updateLikedToUserNotification(String username, Long studyBoardId) {
        return notificationRepository.likedThisPost(username, studyBoardId);
    }
}
