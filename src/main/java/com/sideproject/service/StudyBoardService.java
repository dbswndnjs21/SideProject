package com.sideproject.service;

import com.sideproject.dto.StudyBoardContentDto;
import com.sideproject.dto.StudyBoardListDto;
import com.sideproject.repository.StudyBoardCustomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudyBoardService {
    private final StudyBoardCustomRepository studyBoardCustomRepository;

    public StudyBoardContentDto findStudyInfoById(Long id) {
        return studyBoardCustomRepository.findStudyInfoById(id);
    }

//    public List<StudyBoardListDto> findStudyListOrderByDESC() {
//        return studyBoardCustomRepository.findStudyList();
//    }
}
