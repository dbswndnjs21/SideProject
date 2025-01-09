package com.sideproject.controller;

import com.sideproject.jwt.JWTUtil;
import com.sideproject.service.IsLikedService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class IsLikedApiController {
    private final IsLikedService isLikedService;
    private final JWTUtil jwtUtil; // user 정보를 가져오기 위해

    @PostMapping("/likes")
//    public String Liked(HttpServletRequest request, @RequestParam("studyBoardId")Long studyBoardId) {
    public String Liked(@RequestParam("studyBoardId")Long studyBoardId) {
        String username = "wltn";
//        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        Long state = isLikedService.updateLike(username, studyBoardId);
        if(state > 0) {
            return "success";
        }
        return "fail";
    }

}
