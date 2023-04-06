package com.example.myQuestProject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myQuestProject.dtos.PostCreateDto;
import com.example.myQuestProject.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

	List<Post> findByUserId(Long userId);

	Post save(PostCreateDto data);
	
	Post findOneById(Long id);

}