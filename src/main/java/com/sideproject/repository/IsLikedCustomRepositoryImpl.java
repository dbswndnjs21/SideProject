package com.sideproject.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sideproject.entity.QLikes;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class IsLikedCustomRepositoryImpl implements IsLikedCustomRepository{
    private final JPAQueryFactory jpaQueryFactory;

    private final QLikes likes = QLikes.likes;

    @Override
    public Long updateLiked(Long userId, Long studyBoardId){
        // delete에 의해 is_liked가 false가 된 데이터일수도 있기 때문에 확인하는 로직
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
                .insert (likes)
                .set(likes.userId, userId)
                .set(likes.studyBoardId, studyBoardId)
                .set(likes.isLiked, true)
                .execute();

        if(insertedCount > 0) {
            return insertedCount;
        }

        return null;
    }

    @Override
    public Long deleteLiked(Long userId, Long studyBoardId) {
        long deletedCount = jpaQueryFactory
                .delete(likes)
                .where(likes.userId.eq(userId)
                        .and(likes.studyBoardId.eq(studyBoardId)))
                .execute();
        if(deletedCount > 0) {
            return deletedCount;
        }
        return null;
    }

}
