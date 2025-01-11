package com.sideproject.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class NotificationDto {
    private Long id;
    private String title;
    private String username;
    private String picUrl;
    private String message;
    private Boolean isRead;
    private Boolean isDeleted;
    private LocalDateTime createdAt;
}
