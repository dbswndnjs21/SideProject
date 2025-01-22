package com.sideproject.repository;

import com.sideproject.dto.LikesDto;
import com.sideproject.dto.NotificationDto;

public interface NotificationCustomRepository {
        // 글 작성자에게 보내는 알림 데이터 저장
        Long likedYourPost(String username, Long studyBoardId);
        // 사용자에게 본인이 좋아요 누른 알림 데이터 저장
        Long likedThisPost(String username, Long studyBoardId);
}
