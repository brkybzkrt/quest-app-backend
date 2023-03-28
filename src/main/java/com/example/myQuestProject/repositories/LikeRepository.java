package com.example.myQuestProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myQuestProject.entities.Like;

public interface LikeRepository extends JpaRepository<Like, Long> {

}
