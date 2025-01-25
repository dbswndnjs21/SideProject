package com.sideproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationTypeDto {
    private Long id;
    private String notificationType;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
