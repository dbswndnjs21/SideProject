package com.sideproject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "notification")
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // notificationType 테이블의 id
    @Column(name = "notification_type_id")
    private Long notificationTypeId;

    @Column(name = "title")
    private String title;

    @Column(name = "username")
    private String receiver;

    @Column(name = "pic_url")
    private String picUrl;

    @Column(name = "message")
    private String message;

    @Column(name = "url")
    private String url;

    @Column(name = "is_read", nullable = false)
    private Boolean isRead;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
