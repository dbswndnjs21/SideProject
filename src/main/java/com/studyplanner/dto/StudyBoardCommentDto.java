package com.studyplanner.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class StudyBoardCommentDto {
    private Long id;
    private Long studyBoardId;
    private Long userId;
    private String comment;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
