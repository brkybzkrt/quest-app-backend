package com.example.myQuestProject.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myQuestProject.services.LikeService;

@RestController
@RequestMapping("/likes")
public class LikeController {

	
	private LikeService likeService;

	public LikeController(LikeService likeService) {

		this.likeService = likeService;
	}
}
