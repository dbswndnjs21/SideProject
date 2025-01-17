package com.sideproject.repository;

import com.sideproject.dto.LikesDto;
import com.sideproject.dto.NotificationDto;

public interface NotificationCustomRepository {
    // 좋아요 테이블에 데이터 변동 알림 필요한 경우 -> 알림 테이블에 데이터 적재

    // 사용자가 좋아요 클릭하는 경우 -> 해당 사용자에게 좋아요 알림 + 작성자에게 좋아요 알림
        NotificationDto likedYourPost(Long userId, Long studyBoardId);

    // 사용자가 좋아요를 취소하는 경우 -> 해당 사용자에게 좋아요 취소 알림
//    NotificationDto save(NotificationDto notificationDto);
}
