package com.studyplanner.service;

import com.studyplanner.dto.StudyBoardContentDto;
import com.studyplanner.repository.StudyBoardCustomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class StudyBoardDetailService {
    private final StudyBoardCustomRepository studyBoardCustomRepository;

    public StudyBoardDetailService(@Qualifier("studyBoardRepository") StudyBoardCustomRepository studyBoardCustomRepository) {
        this.studyBoardCustomRepository = studyBoardCustomRepository;
    }

    public StudyBoardContentDto findStudyInfoById(Long id) {
        return studyBoardCustomRepository.findStudyInfoById(id);
    }
}
