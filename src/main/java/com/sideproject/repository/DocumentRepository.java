package com.sideproject.repository;

import com.sideproject.dto.DocumentDto;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class DocumentRepository {

    private final RedisTemplate<String, DocumentDto> redisTemplate;
    private final HashOperations<String, String, DocumentDto> hashOperations;

    @Autowired
    public DocumentRepository(RedisTemplate<String, DocumentDto> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
    }

    public void save(DocumentDto document) {
        hashOperations.put("DOCUMENT", document.getId(), document);
    }

    public DocumentDto findById(String id) {
        return hashOperations.get("DOCUMENT", id);
    }

    public void delete(String id) {
        hashOperations.delete("DOCUMENT", id);
    }
}
