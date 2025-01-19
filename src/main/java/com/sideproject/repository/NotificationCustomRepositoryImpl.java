package com.sideproject.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sideproject.dto.NotificationDto;
import com.sideproject.entity.QNotification;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class NotificationCustomRepositoryImpl implements NotificationCustomRepository {
    private final JPAQueryFactory jpaQueryFactory;

    private final QNotification notification = QNotification.notification;

    // TODO: 알림 적재하기
    @Override
    @Transactional
    public Long likedYourPost(Long userId, Long studyBoardId){

        long saveNotification = jpaQueryFactory
                .insert(notification)
                .columns(notification.title, notification.username, notification.picUrl, notification.message, notification.isRead,
                         notification.isDeleted)
                .values("좋아요 알림", username, )
    }
}
