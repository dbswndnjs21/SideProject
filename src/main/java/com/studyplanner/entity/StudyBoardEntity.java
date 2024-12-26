package com.studyplanner.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudyBoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    private String username; join 해서 유저정보 가져오기
    private String title;
    private LocalDate endDate;
    private int state; // 1: 모집중 0: 모집완료
    private int icon; // 기술스택 아이콘
    private String content; // 프로젝트에 관한 간략한 설명
    private int participants; // 모집인원
    private LocalDate strDate; // 시작예정일
    private int EstimantedTime; // 예상기간
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
