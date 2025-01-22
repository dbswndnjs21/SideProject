package com.sideproject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "notification_type")
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationType {
    // TODO: 테이블 수정 필요!!
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "notification_type")
    private String notificationType;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
