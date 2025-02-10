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

    public Long updateLike(String username, Long studyBoardId){
        return isLikedRepository.updateLiked(username, studyBoardId);
    }

    public Long deleteLike(String username, Long studyBoardId){
        return isLikedRepository.deleteLiked(username, studyBoardId);
    }
}
