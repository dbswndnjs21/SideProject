package com.studyplanner.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.studyplanner.dto.StudyBoardCommentDto;
import com.studyplanner.dto.StudyBoardContentDto;
import com.studyplanner.entity.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StudyBoardRepositoryCustomImpl implements StudyBoardCustomRepository {
    private final JPAQueryFactory jpaQueryFactory;

    private final QStudyBoardComment comment = QStudyBoardComment.studyBoardComment;
    private final QStudyBoard studyBoard = QStudyBoard.studyBoard;
    private final QUser user = QUser.user;

    @Override
    public StudyBoardContentDto findStudyInfoById(Long id) {
        StudyBoardContentDto studyBoardContentDto = jpaQueryFactory
                .select(Projections.fields(StudyBoardContentDto.class,
                        studyBoard.id,
                        studyBoard.title,
                        studyBoard.endDate,
                        studyBoard.state,
                        studyBoard.icon,
                        studyBoard.description,
                        studyBoard.participants,
                        studyBoard.strDate,
                        studyBoard.estimatedTime,
                        studyBoard.createdAt,
                        studyBoard.updatedAt,
                        user.username))
                .from(studyBoard)
                .join(user).on(studyBoard.userId.eq(user.id))
                .where(studyBoard.id.eq(id)) // and studyBoard.isWithdraw 칼럼이 0 인것도 추가
                .orderBy(studyBoard.id.desc())
                .fetchOne();

        List<StudyBoardCommentDto> comments = jpaQueryFactory
                .select(Projections.fields(StudyBoardCommentDto.class,
                        comment.userId,
                        user.picUrl,
                        comment.comment,
                        comment.createdAt))
                .from(comment)
                .join(studyBoard).on(comment.studyBoardId.eq(studyBoard.id))
                .join(user).on(comment.userId.eq(user.id))
                .where(comment.studyBoardId.eq(id))
                .orderBy(comment.count().desc())
                .fetch();

        if(studyBoardContentDto != null) {
            studyBoardContentDto.setComments(comments);
        }

        return studyBoardContentDto;
    }
}