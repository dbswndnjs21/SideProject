package com.studyplanner.service;

import com.studyplanner.dto.StudyBoardContentDto;
import com.studyplanner.repository.StudyBoardCustomRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class StudyBoardDetailService {
    private final StudyBoardCustomRepository studyBoardCustomRepository;

    // TODO: @Qualifier("studyBoardRepository") 없으면 애러발생(parameter)하는 이유 알아보기
    public StudyBoardDetailService(@Qualifier("studyBoardRepository") StudyBoardCustomRepository studyBoardCustomRepository) {
        this.studyBoardCustomRepository = studyBoardCustomRepository;
    }

    public StudyBoardContentDto findStudyInfoById(Long id) {
        return studyBoardCustomRepository.findStudyInfoById(id);
    }
}
