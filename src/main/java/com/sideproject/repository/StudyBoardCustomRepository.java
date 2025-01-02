package com.sideproject.repository;

import com.sideproject.dto.StudyBoardContentDto;
import com.sideproject.dto.StudyBoardListDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudyBoardCustomRepository {
    StudyBoardContentDto findStudyInfoById(Long id);

//    List<StudyBoardListDto> findStudyList();
}