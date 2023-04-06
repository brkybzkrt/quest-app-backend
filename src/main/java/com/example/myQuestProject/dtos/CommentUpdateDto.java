package com.example.myQuestProject.dtos;

import lombok.Data;

@Data
public class CommentUpdateDto {

	String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
