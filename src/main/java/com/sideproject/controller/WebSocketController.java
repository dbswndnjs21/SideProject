package com.sideproject.controller;

import ch.qos.logback.core.model.Model;
import com.sideproject.dto.DocumentDto;
import com.sideproject.service.DocumentService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebSocketController {

    private final DocumentService documentService;

    public WebSocketController(DocumentService documentService) {
        this.documentService = documentService;
    }


    //setApplicationDestinationPrefixes 설정으로 MessageMapping에는 /app 경로가 접두사로 붙는다
    @MessageMapping("/update")
    @SendTo("/topic/documents") //여기랑
    public DocumentDto updateDocument(DocumentDto document) {
        documentService.createOrUpdateDocument(document);
        return document;
    }

    // 클라이언트가 문서를 요청하는 경로
    @MessageMapping("/getDocument")
    @SendTo("/topic/documents") //에 @SendTo("/topic/documents/{id}") 작업 해줘야함
    // 값 받을땐@DestinationVariable 써서 하면됨
    public DocumentDto getDocument(DocumentDto request) {
        // 요청된 ID에 해당하는 문서를 Redis나 DB에서 조회
        DocumentDto document = documentService.findById(request.getId());
        return document;
    }


    @GetMapping("/websocket")
    public String index2(@RequestParam Long documentId) {
        System.out.println("웹소켓 타는지");
        return "websocket";
    }

    @GetMapping("/websocketList")
    public String websocketListForm() {
        System.out.println("웹소켓List 타는지");
        return "websocketList";
    }

    @GetMapping("/websocketCreate")
    public String websocketCreateForm() {
        System.out.println("웹소켓Create 타는지");
        return "websocketCreate";
    }

}