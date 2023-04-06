package com.example.myQuestProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.myQuestProject.dtos.PostCreateDto;
import com.example.myQuestProject.dtos.PostUpdateDto;
import com.example.myQuestProject.entities.Post;
import com.example.myQuestProject.entities.User;
import com.example.myQuestProject.repositories.PostRepository;
import com.example.myQuestProject.repositories.UserRepository;

@Service
public class PostService {

	
	private PostRepository postRepository;
	private UserService userService;
	
	public PostService(PostRepository postRepository,UserService userService) {
		this.postRepository = postRepository;
		this.userService = userService;
	}

	
	public Post getOneById(@PathVariable Long id){
		return postRepository.findOneById(id);
	}
	
	
	public List<Post> getAllPosts(){
		return postRepository.findAll();
	}
	
	
	public List<Post> getAllPostsByUserId(@PathVariable Long userId){
		return postRepository.findByUserId(userId);
	}


	public Post createPost(PostCreateDto data) {
		
		 User isExist = userService.getOneById(data.getUserId());
		 
		 if(isExist != null)
		 {
			 Post newPost= new Post();
			 newPost.setId(data.getId());
			 newPost.setText(data.getText());
			 newPost.setTitle(data.getTitle());
			 newPost.setUser(isExist);
		 }else {
			 throw new Error("User bulunamadı");
		 }
		 
		
		return postRepository.save(data);
	}


	public Post updatePostById(Long id, PostUpdateDto data) {
		
		Optional<Post> oldPost= postRepository.findById(id);
		
		if(oldPost.isPresent()) 
		{
			Post post= oldPost.get();
				post.setText(data.getText());
				post.setTitle(data.getTitle());
				postRepository.save(post);
			
				return post;
		}else {
			throw new Error("Post bulunamadı");
		}
	}


	public void deletePostById(Long id) {
		Optional<Post> post= postRepository.findById(id);
		if(post.isPresent()) 
		{
			postRepository.deleteById(id);
				
		}else {
			throw new Error("Post bulunamadı");
		}
	}
}
