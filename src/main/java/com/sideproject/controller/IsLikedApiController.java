package com.sideproject.controller;

import com.sideproject.jwt.JWTUtil;
import com.sideproject.service.IsLikedService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class IsLikedApiController {
    private final IsLikedService isLikedService;
    private final JWTUtil jwtUtil; // user 정보를 가져오기 위해

//    @PostMapping("/likes")
//    public Long Liked(HttpServletRequest request) {}

}
