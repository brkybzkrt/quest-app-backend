package com.example.myQuestProject.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myQuestProject.dtos.PostCreateDto;
import com.example.myQuestProject.dtos.PostUpdateDto;
import com.example.myQuestProject.entities.Post;
import com.example.myQuestProject.services.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {

	
	private PostService postService;

	public PostController(PostService postService) {

		this.postService = postService;
	}
	
	@GetMapping("/{id}")
	public Optional<Post> getOneById(@PathVariable Long id){
		return postService.getOneById(id);
	}
	
	
	@GetMapping
	public List<Post> getAllPosts(){
		return postService.getAllPosts();
	}
	
	@GetMapping("/{userId}")
	public List<Post> getAllPostsByUserId(@PathVariable Long userId){
		return postService.getAllPostsByUserId(userId);
	}
	
	
	@PostMapping
	public  Post createPost(@RequestBody PostCreateDto data) {
		return postService.createPost(data);
	}
	
	
	@PutMapping("/{id}")
	public Post updatePostById(@PathVariable Long id, @RequestBody PostUpdateDto data){
		return postService.updatePostById(id, data);
	
	}
	
	
	@DeleteMapping("/{id}")
	public void deletePostById(@PathVariable Long id){
		postService.deletePostById(id);
	}
	
}
