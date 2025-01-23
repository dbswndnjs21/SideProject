package com.sideproject.repository;

import com.sideproject.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Boolean existsByUsername(String username);

    UserEntity findByUsername(String username);

    @Query("SELECT u FROM UserEntity u WHERE u.id IN :ids")
    List<UserEntity> findAllById(@Param("ids") List<Long> ids);

}