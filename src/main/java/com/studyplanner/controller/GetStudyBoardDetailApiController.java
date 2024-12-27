package com.studyplanner.controller;

import com.studyplanner.dto.StudyBoardContentDto;
import com.studyplanner.service.StudyBoardDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
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