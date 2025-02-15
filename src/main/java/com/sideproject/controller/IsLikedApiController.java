package com.sideproject.controller;

import com.sideproject.jwt.JWTUtil;
import com.sideproject.service.IsLikedService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class IsLikedApiController {
    private final IsLikedService isLikedService;

    @PostMapping("/likes")
    public String Liked(@RequestParam("studyBoardId") Long studyBoardId) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        Long state = isLikedService.updateLike(username, studyBoardId);
        if(state > 0) {
            return "success";
        }
        return "fail";
    }

    @PostMapping("/canceled/liked")
    public String CanceledLiked(@RequestParam("studyBoardId") Long studyBoardId) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        Long state = isLikedService.deleteLike(username, studyBoardId);
        if(state > 0) {
            return "success";
        }
        return "fail";
    }
}