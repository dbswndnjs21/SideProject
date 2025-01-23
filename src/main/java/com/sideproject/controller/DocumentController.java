package com.sideproject.controller;

import com.sideproject.dto.DocumentDto;
import com.sideproject.dto.RoomParticipantDto;
import com.sideproject.dto.UserEntityDto;
import com.sideproject.entity.RoomParticipant;
import com.sideproject.repository.DocumentRepository;
import com.sideproject.service.DocumentService;
import com.sideproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/documents")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentRepository documentRepository;
    private final DocumentService documentService;
    private final UserService userService;

//    @PostMapping
//    public ResponseEntity<DocumentDto> createDocument(@RequestBody DocumentDto document) {
//        documentRepository.save(document);
//        return new ResponseEntity<>(document, HttpStatus.CREATED);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentDto> getDocument(@PathVariable String id) {
        DocumentDto document = documentRepository.findById(id);
        if (document != null) {
            return new ResponseEntity<>(document, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocument(@PathVariable String id) {
        documentRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public List<RoomParticipantDto> getUserDocuments(Principal principal) {
        System.out.println("getUserDocuments 실행여부 " + principal.getName());
        String userId = principal.getName();
        UserEntityDto userByUsername = userService.getUserByUsername(userId);
        return documentService.getDocumentsForUser(userByUsername.getId());
    }
}