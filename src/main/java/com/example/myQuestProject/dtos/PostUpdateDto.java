package com.example.myQuestProject.dtos;

import lombok.Data;

@Data
public class PostUpdateDto {

	
	String text;
	String title;
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
}
