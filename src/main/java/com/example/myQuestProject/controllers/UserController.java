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

import com.example.myQuestProject.entities.User;
import com.example.myQuestProject.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	
	private UserService userService;
	
	public UserController( UserService userService) {
		this.userService = userService;
	}
	
	
	
	@GetMapping
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	
	@PostMapping
	public  User createUser(@RequestBody User data) {
		return userService.createUser(data);
	}
	
	@GetMapping("/{id}")
	public User getOneById(@PathVariable Long id){
		return userService.getOneById(id);
	}
	
	
	@PutMapping("/{id}")
	public User updateUserById(@PathVariable Long id, @RequestBody User data){
		return userService.updateUserById(id, data);
	
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteUserById(@PathVariable Long id){
		 userService.deleteUserById(id);
	}
	
}
