package com.studyplanner.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudyBoardDto {
    private Long id;
    private String title;
    private LocalDate endDate;
    private int state; // 1: 모집중 0: 모집완료
    private int icon; // 기술스택 아이콘
    private String description; // 프로젝트에 관한 간략한 설명
    private int participants; // 모집인원
    private LocalDate strDate; // 시작예정일
    private String estimantedTime; // 예상기간
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
