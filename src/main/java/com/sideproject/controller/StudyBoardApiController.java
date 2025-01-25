package com.sideproject.controller;

import com.sideproject.dto.StudyBoardContentDto;
import com.sideproject.dto.StudyBoardListDto;
import com.sideproject.service.StudyBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/get")
@RequiredArgsConstructor
public class StudyBoardApiController {
    private final StudyBoardService studyBoardService;

    @GetMapping("/detail/{id}")
    public ResponseEntity<StudyBoardContentDto> getStudyBoardDetail(@PathVariable Long id){
        StudyBoardContentDto detail = studyBoardService.findStudyInfoById(id);

        return ResponseEntity.ok(detail);
    }

    @GetMapping("/studyList")
    public ResponseEntity<List<StudyBoardListDto>> getStudyBoardList(){
        List<StudyBoardListDto> list = studyBoardService.findStudyListOrderByDESC();

        return ResponseEntity.ok(list);
    }
}