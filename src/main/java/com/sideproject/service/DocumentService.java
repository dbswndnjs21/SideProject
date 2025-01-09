package com.sideproject.service;

import com.sideproject.dto.DocumentDto;
import com.sideproject.repository.DocumentRepository;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public void createOrUpdateDocument(DocumentDto document) {
        documentRepository.save(document);
    }

    public DocumentDto getDocument(String id) {
        return documentRepository.findById(id);
    }

    // Redis나 DB에서 문서 조회
    public DocumentDto findById(String id) {
        // 예시로 Redis에서 문서 조회 (Repository 사용)
        return documentRepository.findById(id);
    }
}