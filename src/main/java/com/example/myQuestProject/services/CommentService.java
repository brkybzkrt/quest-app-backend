package com.example.myQuestProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.myQuestProject.dtos.CommentCreateDto;
import com.example.myQuestProject.dtos.CommentUpdateDto;
import com.example.myQuestProject.dtos.PostCreateDto;
import com.example.myQuestProject.dtos.PostUpdateDto;
import com.example.myQuestProject.entities.Comment;
import com.example.myQuestProject.entities.Post;
import com.example.myQuestProject.entities.User;
import com.example.myQuestProject.repositories.CommentRepository;

@Service
public class CommentService {

	
	private CommentRepository commentRepository;
	private UserService userService;
	private PostService postService;
	
	
	public CommentService(CommentRepository commentRepository, UserService userService, PostService postService) {

		this.commentRepository = commentRepository;
		this.postService = postService;
		this.userService = userService;
	}


	public Optional<Comment> getOneById( Long id){
		return commentRepository.findById(id);
	}
	
	
	public List<Comment> getAllComments(){
		return commentRepository.findAll();
	}
	
	
	public List<Comment> getAllCommentsByUserId( Long userId){
		return commentRepository.findByUserId(userId);
	}

	public List<Comment> getAllCommentsByUserIdAndPostId(Long userId, Long postId){
		try {
			if(userId != null || postId != null) {
				return commentRepository.findByUserIdAndPostId(userId,postId);
			}else {
				throw new Error("userId veya postId gelmedi");
			}
			
		} catch (Exception e) {
			throw new Error(e);
		}
		
	}


	public Comment createComment(CommentCreateDto data) {
		
		 User userIsExist = userService.getOneById(data.getUserId());
		 Post postIsExist = postService.getOneById(data.getPostId());
		 
		 Comment newComment= new Comment();
		 if(userIsExist != null || postIsExist != null)
		 {
			
			 newComment.setId(data.getId());
			 newComment.setText(data.getText());
		
			 newComment.setUser(userIsExist);
			 newComment.setPost(postIsExist);
		 }else {
			 throw new Error("User veya post bulunamadı");
		 }
		 
		
		return commentRepository.save(newComment);
	}


	public Comment updateCommentById(Long id, CommentUpdateDto data) {
		
		Optional<Comment> oldComment= commentRepository.findById(id);
		
		if(oldComment.isPresent()) 
		{
			Comment comment= oldComment.get();
				comment.setText(data.getText());
				commentRepository.save(comment);
			
				return comment;
		}else {
			throw new Error("Comment bulunamadı");
		}
	}


	public void deleteCommentById(Long id) {
		Optional<Comment> comment= commentRepository.findById(id);
		if(comment.isPresent()) 
		{
			commentRepository.deleteById(id);
				
		}else {
			throw new Error("Comment bulunamadı");
		}
	}
}
