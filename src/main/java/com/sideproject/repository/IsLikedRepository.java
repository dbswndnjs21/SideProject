package com.sideproject.repository;

import com.sideproject.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IsLikedRepository extends JpaRepository<Likes, Long>, IsLikedCustomRepository{

}
