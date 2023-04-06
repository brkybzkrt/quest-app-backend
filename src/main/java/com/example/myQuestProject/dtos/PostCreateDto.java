package com.example.myQuestProject.dtos;

import lombok.Data;

@Data
public class PostCreateDto {

	

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	String text;
	String title;
	Long userId;
}
