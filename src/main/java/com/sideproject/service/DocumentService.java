package com.sideproject.service;

import com.sideproject.dto.DocumentDto;
import com.sideproject.dto.RoomParticipantDto;
import com.sideproject.entity.RoomParticipant;
import com.sideproject.repository.DocumentRepository;
import com.sideproject.repository.RoomParticipantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DocumentService {

    private final DocumentRepository documentRepository;
    private final RoomParticipantRepository roomParticipantRepository;

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

    public List<RoomParticipantDto> getDocumentsForUser(Long userId) {
        return roomParticipantRepository.findByUserId(userId).stream()
                .map(RoomParticipantDto::new) // RoomParticipant 엔티티를 RoomParticipantDto로 변환
                .collect(Collectors.toList());
    }
}