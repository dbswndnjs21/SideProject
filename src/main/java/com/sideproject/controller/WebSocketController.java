package com.sideproject.controller;

import com.sideproject.dto.DocumentDto;
import com.sideproject.service.DocumentService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    private final DocumentService documentService;

    public WebSocketController(DocumentService documentService) {
        this.documentService = documentService;
    }


    //setApplicationDestinationPrefixes 설정으로 MessageMapping에는 /app 경로가 접두사로 붙는다
    @MessageMapping("/update")
    @SendTo("/topic/documents")
    public DocumentDto updateDocument(DocumentDto document) {
        documentService.createOrUpdateDocument(document);
        return document;
    }

    // 클라이언트가 문서를 요청하는 경로
    @MessageMapping("/getDocument")
    @SendTo("/topic/documents")
    public DocumentDto getDocument(DocumentDto request) {
        // 요청된 ID에 해당하는 문서를 Redis나 DB에서 조회
        DocumentDto document = documentService.findById(request.getId());
        return document;
    }
}