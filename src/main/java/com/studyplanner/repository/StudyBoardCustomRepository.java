package com.studyplanner.repository;

import com.studyplanner.dto.StudyBoardContentDto;

public interface StudyBoardCustomRepository {
    StudyBoardContentDto findStudyInfoById(Long id);
}