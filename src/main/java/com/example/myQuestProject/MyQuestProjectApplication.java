package com.example.myQuestProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//@SpringBootApplication
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class MyQuestProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyQuestProjectApplication.class, args);
		
		
		System.out.println("deneme");
	}

}
