package com.sideproject.service;

import com.sideproject.repository.IsLikedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
