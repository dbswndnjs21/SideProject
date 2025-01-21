package com.sideproject.dto;

import com.sideproject.entity.Notification;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationDto {
    private Long id;
    private String title;
    private String receiver;
    private String picUrl;
    private String message;
    private Boolean isRead;
    private Boolean isDeleted;
    private LocalDateTime createdAt;
}
