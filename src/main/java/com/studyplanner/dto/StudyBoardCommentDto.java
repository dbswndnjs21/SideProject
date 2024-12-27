package com.studyplanner.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class StudyBoardCommentDto {
    private Long id;
    private Long studyBoardId;
    private Long userId;
    private String comment;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
