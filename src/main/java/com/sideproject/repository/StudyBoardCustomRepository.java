package com.sideproject.repository;

import com.sideproject.dto.StudyBoardContentDto;
import com.sideproject.dto.StudyBoardListDto;

import java.util.List;

public interface StudyBoardCustomRepository {
    StudyBoardContentDto findStudyInfoById(Long id);

    List<StudyBoardListDto> findStudyList();

//    void saveStudyBoardContent(String username);
}