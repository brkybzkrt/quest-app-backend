package com.example.myQuestProject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myQuestProject.entities.Like;

public interface LikeRepository extends JpaRepository<Like, Long> {

	List<Like> findByUserId(Long userId);

	List<Like> findByPostId(Long postId);

}
