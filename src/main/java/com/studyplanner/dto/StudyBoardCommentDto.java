package com.studyplanner.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudyBoardCommentDto {
    private int id;
    private String comment;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
