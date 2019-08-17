package com.example.blogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.blogs.model.Blog;

/**
 * 
 * @author lenovo
 *
 */

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
	
}
