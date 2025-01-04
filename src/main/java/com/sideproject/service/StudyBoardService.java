package com.sideproject.service;

import com.sideproject.dto.StudyBoardContentDto;
import com.sideproject.dto.StudyBoardListDto;
import com.sideproject.repository.StudyBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudyBoardService {
    private final StudyBoardRepository studyBoardRepository;

    public StudyBoardContentDto findStudyInfoById(Long id) {
        return studyBoardRepository.findStudyInfoById(id);
    }

    public List<StudyBoardListDto> findStudyListOrderByDESC() {
        return studyBoardRepository.findStudyList();
    }
}
