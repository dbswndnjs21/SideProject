package com.sideproject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "study_board")
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudyBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private String username; join 해서 유저정보 가져오기
    // TODO: username으로 변경
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "title")
    private String title;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "state")
    private Integer state; // 1: 모집중 0: 모집완료

    @Column(name = "icon")
    private String icon; // 기술스택 아이콘

    @Column(name = "description")
    private String description; // 프로젝트에 관한 간략한 설명

    @Column(name = "participants")
    private Integer participants; // 모집인원

    @Column(name = "str_date")
    private LocalDate strDate; // 시작예정일

    @Column(name = "estimated_time")
    private Integer estimatedTime; // 예상기간

    @Column(name = "is_withdrawal")
    private Boolean isWithdrawal;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}