package com.sideproject.dto;

import java.io.Serializable;
import java.util.List;

public class DocumentDto implements Serializable {
    private String id;
    private List<String> content; // List<String>으로 변경

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getContent() { // List<String> 타입으로 변경
        return content;
    }

    public void setContent(List<String> content) { // List<String> 타입으로 변경
        this.content = content;
    }
}