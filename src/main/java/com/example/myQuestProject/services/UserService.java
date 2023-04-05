package com.example.myQuestProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.myQuestProject.entities.User;
import com.example.myQuestProject.repositories.UserRepository;

@Service
public class UserService {

	UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public  User createUser(@RequestBody User data) {
		return userRepository.save(data);
	}
	
	public User getOneById(@PathVariable Long id){
		return userRepository.findOneById(id);
	}
	
	
	public User updateUserById(@PathVariable Long id, @RequestBody User data){
		Optional<User> oldUser= userRepository.findById(id);
		if(oldUser.isPresent()) 
		{
			User user= oldUser.get();
				user.setUserName(data.getUserName());
				user.setFirstName(data.getFirstName());
				user.setLastName(data.getLastName());
				userRepository.save(user);
			
				return user;
		}else {
			return null ;
		}
	}
	
	public void deleteUserById(@PathVariable Long id){
		Optional<User> user= userRepository.findById(id);
		if(user.isPresent()) 
		{
			userRepository.deleteById(id);
				
		}
	}
}
