package com.sideproject.service;

import com.sideproject.repository.IsLikedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IsLikedService {
    private final IsLikedRepository isLikedRepository;

    public Long updateLike(Long userId, Long studyBoardId){
        return isLikedRepository.updateLiked(userId, studyBoardId);
    }

    public Long deleteLike(Long userId, Long studyBoardId){
        return isLikedRepository.deleteLiked(userId, studyBoardId);
    }
}
