/**
 * 
 */
package com.example.myQuestProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myQuestProject.entities.User;

/**
 * @author brkyb
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
