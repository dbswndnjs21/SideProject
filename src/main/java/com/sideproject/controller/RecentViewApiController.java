package com.sideproject.controller;

import com.sideproject.service.RecentViewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class RecentViewApiController {
    private final RecentViewService recentViewService;

    @PostMapping("/recent")
    public void addRecentView(@RequestParam("studyBoardId") Long studyBoardId) {
//    public void addRevcentView(@RequestParam("studyBoardId") Long studyBoardId) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        recentViewService.addPostRecentView(username, studyBoardId);
    }
}