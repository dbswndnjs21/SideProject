package com.sideproject.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class LikesDto {
    private Long id;
    private Long userId;
    private Long StudyBoardId;
    private Boolean isLiked;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
