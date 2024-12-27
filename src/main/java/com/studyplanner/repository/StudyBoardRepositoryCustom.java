package com.studyplanner.repository;

import com.studyplanner.dto.StudyBoardContentDto;

public interface StudyBoardRepositoryCustom {
    StudyBoardContentDto findStudyInfoById(Long id);
}