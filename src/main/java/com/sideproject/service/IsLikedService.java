package com.sideproject.service;

import com.sideproject.repository.IsLikedRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class IsLikedService {
    private final IsLikedRepository isLikedRepository;
    private final UserService userService;

    public Long updateLike(String username, Long studyBoardId){
        // username -> userId를 가져오는 부분이 중복되기 때문에
        // UserService에 따로 빼고 의존성주입으로 해결
        Long userId = userService.getUserIdByUsername(username);

        return isLikedRepository.updateLiked(userId, studyBoardId);
    }

    public Long deleteLike(String username, Long studyBoardId){
        Long userId = userService.getUserIdByUsername(username);

        return isLikedRepository.deleteLiked(userId, studyBoardId);
    }
}
