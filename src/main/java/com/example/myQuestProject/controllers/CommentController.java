package com.example.myQuestProject.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myQuestProject.services.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {

	
	private CommentService commentService;

	public CommentController(CommentService commentService) {
	
		this.commentService = commentService;
	}
}
