package com.sideproject.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sideproject.entity.QLikes;
import com.sideproject.entity.QUserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class IsLikedCustomRepositoryImpl implements IsLikedCustomRepository{
    private final JPAQueryFactory jpaQueryFactory;

    private final QLikes likes = QLikes.likes; // likes 칼럼에 Username 아니고 userId로 넣어준 이유 -> username 수정 가능성
    private final QUserEntity user = QUserEntity.userEntity;

    @Override
    @Transactional
    public Long updateLiked(Long userId, Long studyBoardId){
        // 1. 좋아요 누른 사용자의 userid 찾아오기
        // service단에서 해결
//        Long userId = searchUserId(username);

        // 2. 좋아요 했다가 취소한 사용자인지 확인
        boolean isExisting = jpaQueryFactory
                .selectFrom(likes)
                .where(likes.userId.eq(userId)
                        .and(likes.studyBoardId.eq(studyBoardId)))
                .fetchCount() > 0;

        // is_liked가 false로 변경된 경우 is_liked만 ture로 변경
        if(isExisting){
            long updatedCount = jpaQueryFactory
                    .update(likes)
                    .set(likes.isLiked, true)
                    .where(likes.userId.eq(userId)
                            .and(likes.studyBoardId.eq(studyBoardId)))
                    .execute();

            if(updatedCount > 0) {
                return updatedCount;
            }

            return null;
        }

        // 그렇지 않고 처음 좋아요 클릭된 경우 데이터 삽입
        long insertedCount =  jpaQueryFactory
                .insert(likes)
                .columns(likes.userId, likes.studyBoardId, likes.isLiked)
                .values(userId, studyBoardId, true)
//                .set(likes.userId, userId)
//                .set(likes.studyBoardId, studyBoardId)
//                .set(likes.isLiked, true)
                .execute();

        if(insertedCount > 0) {
            return insertedCount;
        }

        return null;
    }

    @Override
    @Transactional
    public Long deleteLiked(Long userId, Long studyBoardId) {
        // 1. userId 찾아오기
//        Long userId = searchUserId(username);

        long deletedCount = jpaQueryFactory
                .update(likes)
                .set(likes.isLiked, false)
                .where(likes.userId.eq(userId)
                        .and(likes.studyBoardId.eq(studyBoardId)))
                .execute();
        if(deletedCount > 0) {
            return deletedCount;
        }
        return null;
    }

    private Long searchUserId(String username) {
        Long userId = jpaQueryFactory
                .select(user.id)
                .from(user)
                .where(user.username.eq(username))
                .fetchOne();

        // 사용자가 없는 경우 exception 던지기
        if(userId == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return userId;
    }
}
