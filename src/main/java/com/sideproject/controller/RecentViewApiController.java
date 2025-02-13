package com.sideproject.controller;

import com.sideproject.jwt.JWTUtil;
import com.sideproject.service.RecentViewService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class RecentViewApiController {
    private final RecentViewService recentViewService;

    @PostMapping("/recent/{id}")
    public void addRevcentView(@RequestParam("studyBoardId") Long studyBoardId) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        recentViewService.addPostRecentView(username, studyBoardId);
    }
}
