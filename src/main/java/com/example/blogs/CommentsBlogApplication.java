package com.example.blogs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * 
 * @author lenovo
 *
 */

@SpringBootApplication
@EnableJpaAuditing
public class CommentsBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommentsBlogApplication.class, args);
	}
}
