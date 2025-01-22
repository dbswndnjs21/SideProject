package com.sideproject.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sideproject.entity.QNotification;
import com.sideproject.entity.QStudyBoard;
import com.sideproject.entity.QUserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class NotificationCustomRepositoryImpl implements NotificationCustomRepository {
    private final JPAQueryFactory jpaQueryFactory;

    private final QNotification notification = QNotification.notification;
    private final QUserEntity user = QUserEntity.userEntity;
    private final QStudyBoard studyBoard = QStudyBoard.studyBoard;

    @Override
    @Transactional
    public Long likedYourPost(String username, Long studyBoardId){ // 작성자의 글에 좋아요 발생 알림 데이터 적재
        String picUrl = findPicUrlUserId(username);
        String title = findStudyBoardTitleByStudyBoardId(studyBoardId);

        long saveNotificationCount = jpaQueryFactory
                .insert(notification)
                // TODO: 클릭시 사용자가 이동하게 될 url 추가하기
                .columns(notification.title, notification.receiver, notification.picUrl, notification.message, notification.isRead,
                         notification.isDeleted, notification.notificationTypeId)
                .values("좋아요 알림", username, picUrl, username + "님의 " + title + "에 좋아요가 눌렸습니다😊", false, false, 1)
                .execute();

        // 정상적으로 저장된 경우
        if(saveNotificationCount > 0){
            return saveNotificationCount;
        }
        // 저장되지 않은 경우
        return null;
    }

    @Override
    @Transactional
    public Long likedThisPost(String username, Long studyBoardId){ // 사용자가 좋아요 누름 알림 데이터 적재
        String picUrl = findPicUrlUserId(username);
        String title = findStudyBoardTitleByStudyBoardId(studyBoardId);

        long saveNotificationCount = jpaQueryFactory
                .insert(notification)
                .columns(notification.title, notification.receiver, notification.picUrl, notification.message, notification.isRead,
                        notification.isDeleted, notification.notificationTypeId)
                .values("좋아요 알림", username, picUrl, username + "님이 " + title + "에 좋아요를 눌렀습니다😊", false, false, 1)
                .execute();

        // 정상적으로 저장된 경우
        if(saveNotificationCount > 0){
            return saveNotificationCount;
        }
        // 저장되지 않은 경우
        return null;
    }

//    @Transactional(readOnly = true)
//    public String findUsernamebyUserId(Long userId) { // 사용자의 userId
//        String receiver = jpaQueryFactory
//                .select(user.username)
//                .from(user)
//                .where(user.id.eq(userId))
//                .fetchOne();
//
//        return receiver;
//    }
//
//    @Transactional(readOnly = true)
//    public String findWriterbyStudyBoardId(Long studyBoardId) { // 좋아요 눌린 게시글 작성자의 userId
//        String writer = jpaQueryFactory
//                .select(user.username)
//                .from(user)
//                .join(studyBoard).on(user.id.eq(studyBoard.userId))
//                .where(studyBoard.id.eq(studyBoardId))
//                .fetchOne();
//
//        return writer;
//    }

    @Transactional(readOnly = true)
    public String findPicUrlUserId(String username) {
        String picUrl = jpaQueryFactory
                .select(user.picUrl)
                .from(user)
                .where(user.username.eq(username))
                .fetchOne();

        return picUrl;
    }

    @Transactional(readOnly = true)
    public String findStudyBoardTitleByStudyBoardId(Long studyBoardId) {
        String title = jpaQueryFactory
                .select(studyBoard.title)
                .from(studyBoard)
                .where(studyBoard.id.eq(studyBoardId))
                .fetchOne();

        return title;
    }
}