package com.sideproject.repository;

import com.sideproject.dto.LikesDto;
import com.sideproject.dto.NotificationDto;

public interface NotificationCustomRepository {
    // 사용자가 좋아요 클릭하는 경우 -> 해당 사용자에게 좋아요 알림 + 작성자에게 좋아요 알림
    NotificationDto save(NotificationDto notificationDto);
}
