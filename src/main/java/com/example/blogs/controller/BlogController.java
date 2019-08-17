package com.example.blogs.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.blogs.model.Blog;
import com.example.blogs.repository.BlogRepository;

/**
 * 
 * @author lenovo
 *
 */
@RestController
public class BlogController {

    @Autowired
    BlogRepository blogRepository;

    @PostMapping("/blogs")
    public Blog createBlog(@Valid @RequestBody Blog blog) {
    	return blogRepository.save(blog);
    }
}
