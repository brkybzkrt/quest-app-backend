package com.example.myQuestProject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myQuestProject.dtos.CommentCreateDto;
import com.example.myQuestProject.entities.Comment;


public interface CommentRepository extends JpaRepository<Comment, Long> {

	List<Comment> findByUserId(Long userId);
	List<Comment> findByUserIdAndPostId(Long userId,Long postId);
}
