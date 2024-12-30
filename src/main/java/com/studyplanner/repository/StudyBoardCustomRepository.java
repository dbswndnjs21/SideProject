package com.studyplanner.repository;

import com.studyplanner.dto.StudyBoardContentDto;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyBoardCustomRepository {
    StudyBoardContentDto findStudyInfoById(Long id);
}