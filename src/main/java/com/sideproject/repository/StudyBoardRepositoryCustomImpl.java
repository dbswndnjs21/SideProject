//package com.sideproject.repository;
//
//import com.sideproject.dto.CommentsDto;
//import com.sideproject.dto.StudyBoardContentDto;
//import com.sideproject.entity.QComments;
//import com.sideproject.entity.QStudyBoard;
//import com.sideproject.entity.QUser;
//import lombok.RequiredArgsConstructor;
//
//import java.util.List;
//
//@RequiredArgsConstructor
//public class StudyBoardRepositoryCustomImpl implements StudyBoardCustomRepository {
//    private final
////    private final JpaQ jpaQueryFactory;
//
//    private final QComments comments = QComments.comments;
//    private final QStudyBoard studyBoard = QStudyBoard.studyBoard;
//    private final QUser user = QUser.user;
//
//    @Override
//    public StudyBoardContentDto findStudyInfoById(Long id) {
//        StudyBoardContentDto studyBoardContentDto = jpaQueryFactory
//                .select(Projections.fields(StudyBoardContentDto.class,
//                        studyBoard.id,
//                        studyBoard.title,
//                        studyBoard.endDate,
//                        studyBoard.state,
//                        studyBoard.icon,
//                        studyBoard.description,
//                        studyBoard.participants,
//                        studyBoard.strDate,
//                        studyBoard.estimatedTime,
//                        studyBoard.createdAt,
//                        studyBoard.updatedAt,
//                        user.username))
//                .from(studyBoard)
//                .join(user).on(studyBoard.userId.eq(user.id))
//                .where(studyBoard.id.eq(id).and(studyBoard.isWithdrawal.eq(false))) // and studyBoard.isWithdraw 칼럼이 0 인것도 추가
//                .orderBy(studyBoard.id.desc())
//                .fetchOne();
//
//        List<CommentsDto> comment = jpaQueryFactory
//                .select(Projections.fields(CommentsDto.class,
//                        comments.userId,
//                        user.picUrl,
//                        comments.comment,
//                        comments.createdAt))
//                .from(comments)
//                .join(studyBoard).on(comments.studyBoardId.eq(studyBoard.id))
//                .join(user).on(comments.userId.eq(user.id))
//                .where(comments.studyBoardId.eq(id))
//                .orderBy(comments.createdAt.desc())
//                .fetch();
//
//        if(studyBoardContentDto != null) {
//            studyBoardContentDto.setComment(comment);
//        }
//
//        return studyBoardContentDto;
//    }
//}