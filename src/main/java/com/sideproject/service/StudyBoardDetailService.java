package com.sideproject.service;

import com.sideproject.dto.StudyBoardContentDto;
import com.sideproject.repository.StudyBoardCustomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudyBoardDetailService {
    private final StudyBoardCustomRepository studyBoardCustomRepository;

    public StudyBoardContentDto findStudyInfoById(Long id) {
        return studyBoardCustomRepository.findStudyInfoById(id);
    }
}
