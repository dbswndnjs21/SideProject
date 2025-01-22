package com.sideproject.controller;

import com.sideproject.jwt.JWTUtil;
import com.sideproject.service.IsLikedService;
import com.sideproject.service.NotificationService;
import com.sideproject.service.SseService;
import com.sideproject.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class IsLikedApiController {
    private final IsLikedService isLikedService;
    private final JWTUtil jwtUtil; // user 정보를 가져오기 위해
    private final SseService sseService;
    private final UserService userService;
    private final NotificationService notificationService; // notification 데이터 적재를 위해

    @PostMapping("/likes")
    // TODO: 테스트 제거하고 username 클라이언트에서 받아와서 기능 동작하는지 확인
//    public String Liked(HttpServletRequest request, @RequestParam("studyBoardId")Long studyBoardId) {
    public String Liked(@RequestParam("studyBoardId") Long studyBoardId) {
        String username = "wltn"; // TODO: 테스트 끝나면 삭제
//        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        Long state = isLikedService.updateLike(username, studyBoardId);
        if(state > 0) {
            // 좋아요 발생 알림 보내주기
            Long receiverId = isLikedService.getPostUserId(studyBoardId); // 글 작성자 userId
            Long userId = userService.getUserIdfromUsername(username); // 좋아요 누른 사용자 userId

            sseService.sendNotification(receiverId, "작성자님 글에 좋아요 발생");
            sseService.sendNotification(userId, "방금 보신 글에 좋아요를 눌렀습니다");

            // 알림 데이터 저장
            notificationService.updateLikedToWriterNotification(username, studyBoardId);
            notificationService.updateLikedToUserNotification(username, studyBoardId);
            return "success";
        }
        return "fail";
    }

    // TODO: 좋아요 취소 알림 기능 추가하기
    @PostMapping("/canceled/liked")
    public String CanceledLiked(@RequestParam("studyBoardId") Long studyBoardId) {
        String username = "wltn"; // TODO: 테스트 끝나면 삭제

        Long state = isLikedService.deleteLike(username, studyBoardId);
        if(state > 0) {
            return "success";
        }
        return "fail";
    }
}