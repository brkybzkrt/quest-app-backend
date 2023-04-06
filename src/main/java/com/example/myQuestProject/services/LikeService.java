package com.example.myQuestProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.myQuestProject.dtos.LikeCreateDto;
import com.example.myQuestProject.entities.Like;
import com.example.myQuestProject.entities.Post;
import com.example.myQuestProject.entities.User;
import com.example.myQuestProject.repositories.LikeRepository;

@Service
public class LikeService {

	private LikeRepository likeRepository;
	private UserService userService;
	private PostService postService;
	
	public LikeService(LikeRepository likeRepository, UserService userService, PostService postService) {
		
		this.likeRepository = likeRepository;
		this.postService = postService;
		this.userService = userService;
		
	}

	
	
	public Optional<Like> getOneById( Long id){
		return likeRepository.findById(id);
	}
	
	
	public List<Like> getAllLikes(){
		return likeRepository.findAll();
	}
	
	
	public List<Like> getAllLikesByUserId( Long userId){
		return likeRepository.findByUserId(userId);
	}

	public List<Like> getAllLikesByPostId( Long postId){
		try {
			if( postId != null) {
				return likeRepository.findByPostId(postId);
			}else {
				throw new Error("postId gelmedi");
			}
			
		} catch (Exception e) {
			throw new Error(e);
		}
		
	}


	public Like createLike(LikeCreateDto data) {
		
		 User userIsExist = userService.getOneById(data.getUserId());
		 Post postIsExist = postService.getOneById(data.getPostId());
		 
		 Like newLike= new Like();
		 
		 if(userIsExist != null || postIsExist != null)
		 {
			
			 newLike.setId(data.getId());
	
			 newLike.setUser(userIsExist);
			 newLike.setPost(postIsExist);
		 }else {
			 throw new Error("User veya post bulunamadı");
		 }
		 
		
		return likeRepository.save(newLike);
	}


	public void deleteLikeById(Long id) {
		Optional<Like> like= likeRepository.findById(id);
		if(like.isPresent()) 
		{
			likeRepository.deleteById(id);
				
		}else {
			throw new Error("Like bulunamadı");
		}
	}
}
