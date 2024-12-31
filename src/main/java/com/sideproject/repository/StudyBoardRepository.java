package com.sideproject.repository;

import com.sideproject.entity.StudyBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyBoardRepository extends JpaRepository<StudyBoard, Long>, StudyBoardCustomRepository {
}
