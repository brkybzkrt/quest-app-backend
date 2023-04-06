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

import com.example.myQuestProject.dtos.CommentCreateDto;
import com.example.myQuestProject.dtos.CommentUpdateDto;
import com.example.myQuestProject.dtos.PostCreateDto;
import com.example.myQuestProject.dtos.PostUpdateDto;
import com.example.myQuestProject.entities.Comment;
import com.example.myQuestProject.entities.Post;
import com.example.myQuestProject.services.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {

	
	private CommentService commentService;

	public CommentController(CommentService commentService) {
	
		this.commentService = commentService;
	}
	
	
	@GetMapping("/{id}")
	public Optional<Comment> getOneById(@PathVariable Long id){
		return commentService.getOneById(id);
	}
	
	
	@GetMapping
	public List<Comment> getAllComments(){
		return commentService.getAllComments();
	}
	
	@GetMapping("/{userId}")
	public List<Comment> getAllCommentsByUserId(@PathVariable Long userId){
		return commentService.getAllCommentsByUserId(userId);
	}
	
	@GetMapping("/{userId}/{postId}")
	public List<Comment> getAllCommentsByUserId(@PathVariable Long userId,@PathVariable Long postId){
		return commentService.getAllCommentsByUserIdAndPostId(userId,postId);
	}
	
	
	
	@PostMapping
	public  Comment createComment(@RequestBody CommentCreateDto data) {
		return commentService.createComment(data);
	}
	
	
	@PutMapping("/{id}")
	public Comment updateCommentById(@PathVariable Long id, @RequestBody CommentUpdateDto data){
		return commentService.updateCommentById(id, data);
	
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteCommentById(@PathVariable Long id){
		commentService.deleteCommentById(id);
	}
	
}
