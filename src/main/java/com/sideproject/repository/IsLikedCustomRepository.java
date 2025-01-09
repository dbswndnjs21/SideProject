package com.sideproject.repository;

public interface IsLikedCustomRepository {
    Long updateLiked(String username, Long studyBoardId);

    Long deleteLiked(String username, Long studyBoardId);
}
