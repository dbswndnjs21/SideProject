package com.sideproject.controller;

import com.sideproject.dto.StudyBoardContentDto;
import com.sideproject.service.StudyBoardDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/get/detail")
@RequiredArgsConstructor
public class GetStudyBoardDetailApiController {
    private final StudyBoardDetailService studyBoardDetailService;

    @GetMapping("/{id}")
    public ResponseEntity<StudyBoardContentDto>getStudyBoardDetail(@PathVariable Long id){
        StudyBoardContentDto detail = studyBoardDetailService.findStudyInfoById(id);

        return ResponseEntity.ok(detail);
    }
}