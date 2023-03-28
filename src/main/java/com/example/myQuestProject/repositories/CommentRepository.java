package com.example.myQuestProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myQuestProject.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
