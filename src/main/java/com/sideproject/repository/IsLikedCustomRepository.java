package com.sideproject.repository;

public interface IsLikedCustomRepository {
    Long updateLiked(Long userId, Long studyBoardId);

    Long deleteLiked(Long userId, Long studyBoardId);
}
