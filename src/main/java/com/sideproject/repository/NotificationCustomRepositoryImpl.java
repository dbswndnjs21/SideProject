//package com.sideproject.repository;
//
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import com.sideproject.entity.QNotification;
//import lombok.RequiredArgsConstructor;
//import org.springframework.transaction.annotation.Transactional;
//
//@RequiredArgsConstructor
//public class NotificationCustomRepositoryImpl implements NotificationCustomRepository {
//    private final JPAQueryFactory jpaQueryFactory;
//
//    private final QNotification notification = QNotification.notification;
//
//    @Override
//    @Transactional(readOnly = true)
//    public Long updateNotification(Long userId, Long studyBoardId) {
//
//    }
//
//}
