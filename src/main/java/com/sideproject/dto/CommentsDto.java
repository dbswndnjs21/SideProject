package com.sideproject.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentsDto {
    private Long id;
    private Long studyBoardId;
    private Long userId; // 댓글 작성자
    private String comment;
    private Boolean isWithdrawal; // 1: 삭제된 코멘트
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
