package com.sideproject.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class StudyBoardContentDto {
    private Long id;
    private String title;
    private LocalDate endDate;
    private Integer state; // 1: 모집중 0: 모집완료
    private Integer icon; // 기술스택 아이콘
    private String description; // 프로젝트에 관한 간략한 설명
    private Integer participants; // 모집인원
    private LocalDate strDate; // 시작예정일
    private Integer estimatedTime; // 예상기간
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String username;
    private List<CommentsDto> comment;
}
