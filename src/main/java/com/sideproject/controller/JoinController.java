package com.sideproject.controller;

import com.sideproject.dto.JoinDTO;
import com.sideproject.service.JoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class JoinController {

    private final JoinService joinService;

    @PostMapping("/join")
    public ResponseEntity<String> joinProcess(@RequestBody  JoinDTO joinDTO) {
        joinService.joinProcess(joinDTO);

        return ResponseEntity.ok("{\"message\": \"ok\"}");
    }
}