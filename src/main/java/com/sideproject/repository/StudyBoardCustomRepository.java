package com.sideproject.repository;

import com.sideproject.dto.StudyBoardContentDto;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyBoardCustomRepository {
    StudyBoardContentDto findStudyInfoById(Long id);
}