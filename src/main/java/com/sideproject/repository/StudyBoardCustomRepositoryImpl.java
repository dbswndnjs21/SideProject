package com.sideproject.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sideproject.dto.CommentsDto;
import com.sideproject.dto.QStudyBoardListDto;
import com.sideproject.dto.StudyBoardContentDto;
import com.sideproject.dto.StudyBoardListDto;
import com.sideproject.entity.QComments;
import com.sideproject.entity.QStudyBoard;
import com.sideproject.entity.QUserEntity;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class StudyBoardCustomRepositoryImpl implements StudyBoardCustomRepository {
    private final JPAQueryFactory jpaQueryFactory;

    private final QComments comments = QComments.comments;
    private final QStudyBoard studyBoard = QStudyBoard.studyBoard;
    private final QUserEntity user = QUserEntity.userEntity;

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
                .where(studyBoard.id.eq(id)
                        .and(studyBoard.isWithdrawal.eq(false))
                        .and(user.isWithdrawal.eq(0))) // and studyBoard.isWithdraw 칼럼이 0 인것도 추가
                .orderBy(studyBoard.id.desc())
                .fetchOne();

        List<CommentsDto> comment = jpaQueryFactory
                .select(Projections.fields(CommentsDto.class,
                        comments.userId,
                        user.picUrl,
                        comments.comment,
                        comments.createdAt))
                .from(comments)
                .join(studyBoard).on(comments.studyBoardId.eq(studyBoard.id))
                .join(user).on(comments.userId.eq(user.id))
                .where(comments.studyBoardId.eq(id))
                .orderBy(comments.createdAt.desc())
                .fetch();

//        if(studyBoardContentDto != null) {
//            studyBoardContentDto.setComment(comment);
//        }

        return studyBoardContentDto;
    }

    @Override
    public List<StudyBoardListDto> findStudyList(){
        return jpaQueryFactory
                .select(new QStudyBoardListDto(
                        studyBoard.id,
                        user.username,
                        user.picUrl,
                        studyBoard.title,
                        studyBoard.participants,
                        studyBoard.endDate,
                        studyBoard.icon))
                .from(studyBoard)
                .join(user).on(studyBoard.userId.eq(user.id))
                .where(studyBoard.isWithdrawal.eq(false))
                .orderBy(studyBoard.createdAt.desc())
                .fetch();
    }
}