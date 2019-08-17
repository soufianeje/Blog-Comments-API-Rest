package com.example.blogs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.blogs.model.Comment;

/**
 * 
 * @author lenovo
 *
 */

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
	
	List<Comment> findByBlogId(Long postId);

}
