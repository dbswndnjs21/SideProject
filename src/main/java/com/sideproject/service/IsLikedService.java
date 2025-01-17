package com.sideproject.service;

import com.sideproject.repository.IsLikedRepository;
import com.sideproject.repository.StudyBoardRepository;
import com.sideproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IsLikedService {
    private final IsLikedRepository isLikedRepository;
    private final StudyBoardRepository studyBoardRepository;
    private final UserRepository userRepository;

    public Long updateLike(String username, Long studyBoardId){
        return isLikedRepository.updateLiked(username, studyBoardId);
    }

    public Long deleteLike(String username, Long studyBoardId){
        return isLikedRepository.deleteLiked(username, studyBoardId);
    }

    // 게시글 작성자 userId 찾는 메서드
    public Long getPostUserId(Long studyBoardId){
        return studyBoardRepository.findById(studyBoardId)
                .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."))
                .getUserId();
    }

//    // username으로부터 userId 가져오는 메서드
//    public Long getUserIdfromUsername(String username){
//        return userRepository.findByUsername(username)
//                .getId();
//    }
}
