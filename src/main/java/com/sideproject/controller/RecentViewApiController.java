package com.sideproject.controller;

import com.sideproject.dto.UserEntityDto;
import com.sideproject.service.RecentViewService;
import com.sideproject.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class RecentViewApiController {
    private final RecentViewService recentViewService;
    private final UserService userService;

    @PostMapping("/recent")
    public void addRecentView(@RequestParam("studyBoardId") Long studyBoardId) {
//    public void addRevcentView(@RequestParam("studyBoardId") Long studyBoardId) {

        // TODO: username 받아오는 부분 필요
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        System.out.println(authentication.getName());
//
//        String username = SecurityContextHolder.getContext().getAuthentication().getName();
//
//        UserEntityDto userdto = userService.getUserByUsername(username);
//        System.out.println(userdto.getId());

        Long userId = 3L;
        System.out.println(userId);

        recentViewService.addPostRecentView(userId, studyBoardId);
    }
}