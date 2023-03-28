package com.example.myQuestProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myQuestProject.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}