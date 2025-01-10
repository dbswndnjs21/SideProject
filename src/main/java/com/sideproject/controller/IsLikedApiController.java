package com.sideproject.controller;

import com.sideproject.jwt.JWTUtil;
import com.sideproject.service.IsLikedService;
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

    @PostMapping("/likes")
    // TODO: 테스트 제거하고 username 클라이언트에서 받아와서 기능 동작하는지 확인
    // TODO: 반환타입 SSE 연결할 거 생각해서 추후 수정
//    public String Liked(HttpServletRequest request, @RequestParam("studyBoardId")Long studyBoardId) {
    public String Liked(@RequestParam("studyBoardId")Long studyBoardId) {
        String username = "wltn"; // TODO: 테스트 끝나면 삭제 -> username 클라이언트 단에서 가져와야함
//        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        Long state = isLikedService.updateLike(username, studyBoardId);
        if(state > 0) {
            return "success";
        }
        return "fail";
    }

    // TODO: like취소하는 메서드도 마찬가지로 @PostMapping
}
