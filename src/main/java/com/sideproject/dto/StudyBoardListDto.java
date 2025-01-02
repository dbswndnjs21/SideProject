package com.sideproject.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class StudyBoardListDto {
    private Long id;
    private String username;
    private String picUrl;
    private String title;
    private Integer participants;
    private LocalDate endDate;
    private String icon;

    @QueryProjection
    public StudyBoardListDto(Long id, String username, String picUrl, String title, Integer participants, LocalDate endDate, String icon) {
        this.id = id;
        this.username = username;
        this.picUrl = picUrl;
        this.title = title;
        this.participants = participants;
        this.endDate = endDate;
        this.icon = icon;
    }
}
