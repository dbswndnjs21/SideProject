package com.sideproject.controller;

import com.sideproject.dto.UserEntityDto;
import com.sideproject.service.RecentViewService;
import com.sideproject.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/recent")
public class RecentViewApiController {
    private final RecentViewService recentViewService;
    private final UserService userService;

    @PostMapping
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

    @GetMapping("/view")
    public ResponseEntity<Set<Long>> getRecentViewPosts(@RequestParam("username") String username) {
        Long userId = userService.getUserIdByUsername(username);
        Set<Long> postIds = recentViewService.getViewsData(userId, 5);
        return ResponseEntity.ok(postIds);
    }

}