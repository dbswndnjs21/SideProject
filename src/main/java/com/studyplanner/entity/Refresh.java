package com.studyplanner.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "refresh")
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Refresh {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "refresh")
    private String refresh;

    @Column(name = "expiration")
    private String expiration;
}