package com.example.blogs.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author lenovo
 *
 */

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String sayHello() {
        return "Welcome to the Blog's Comments API Rest. You can get all the blog's comments, create, update and delete comments.";
    }
}
