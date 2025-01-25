package com.sideproject.controller;

import com.sideproject.dto.StudyBoardContentDto;
import com.sideproject.dto.StudyBoardDto;
import com.sideproject.dto.StudyBoardListDto;
import com.sideproject.request.SaveStudyBoardPostRequest;
import com.sideproject.service.StudyBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/studyBoard")
@RequiredArgsConstructor
public class StudyBoardController {
    private final StudyBoardService studyBoardService;

    // TODO: 글 save하는 메서드 필요
//    @PostMapping("/save")
//    public Long savePost(@RequestBody SaveStudyBoardPostRequest saveStudyBoardPostRequest) {
//        return studyBoardService.save(saveStudyBoardPostRequest);
//    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<StudyBoardContentDto> getStudyBoardDetail(@PathVariable Long id){
        StudyBoardContentDto detail = studyBoardService.findStudyInfoById(id);

        return ResponseEntity.ok(detail);
    }

    @GetMapping("/list")
    public ResponseEntity<List<StudyBoardListDto>> getStudyBoardList(){
        List<StudyBoardListDto> list = studyBoardService.findStudyListOrderByDESC();

        return ResponseEntity.ok(list);
    }

//    @PostMapping("/save/post")
//    public ResponseEntity<StudyBoardDto> saveStudyBoard(@RequestBody StudyBoardDto studyBoardDto){
//        log.info("저장확인: {}", studyBoardDto);
//        Long studyBoardId =
//    }
}