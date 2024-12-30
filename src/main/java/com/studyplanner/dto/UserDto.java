package com.studyplanner.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String picUrl;
    private String role; // 권한
    private Boolean isWithdrawal; // 1: 탈퇴한 회원
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
