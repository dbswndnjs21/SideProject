package com.studyplanner.dto;

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

    @QueryProjection
    public StudyBoardContentDto(Long id, String title, LocalDate endDate, Integer state, Integer icon, String description, Integer participants, LocalDate strDate, Integer estimatedTime, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.endDate = endDate;
        this.state = state;
        this.icon = icon;
        this.description = description;
        this.participants = participants;
        this.strDate = strDate;
        this.estimatedTime = estimatedTime;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
