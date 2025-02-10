package com.sideproject.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String role; // 권한
    private String picUrl;
    private Integer isWithdrawal; // 1: 탈퇴한 회원
}
