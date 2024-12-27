package com.studyplanner.repository;

import com.studyplanner.entity.StudyBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyBoardRepository extends JpaRepository<StudyBoard, Long>, StudyBoardCustomRepository {
}
