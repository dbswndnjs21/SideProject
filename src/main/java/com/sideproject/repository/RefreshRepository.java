package com.sideproject.repository;

import com.sideproject.entity.RefreshEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RefreshRepository extends JpaRepository<RefreshEntity, Long> {

    Boolean existsByRefresh(String refresh);

    @Transactional
    void deleteByRefresh(String refresh);

    @Modifying
    @Transactional
    @Query("DELETE FROM RefreshEntity r WHERE r.expiration < :currentDate")
    void deleteExpiredTokens(@Param("currentDate") String currentDate);
}