package com.example.myQuestProject.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="like_1")
@Data
public class Like {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="postId",nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	Post post;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="userId",nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	User user;
}
