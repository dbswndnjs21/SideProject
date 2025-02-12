package com.sideproject.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class DocumentDto {
    private String id;
    private String title;
    private List<String> content; // List<String>으로 변경
    private Set<String> participants;

}