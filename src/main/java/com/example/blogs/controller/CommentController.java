package com.example.blogs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.blogs.exception.ResourceNotFoundException;
import com.example.blogs.model.Comment;
import com.example.blogs.repository.BlogRepository;
import com.example.blogs.repository.CommentRepository;

/**
 * 
 * @author lenovo
 *
 */
@RestController
public class CommentController {

    @Autowired
    CommentRepository commentRepository;
    
    @Autowired
    BlogRepository blogRepository;

    @GetMapping("/comments")
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @PostMapping("/blogs/{id}/comments")
    public Comment createComment(@PathVariable (value = "id") Long id, @Valid @RequestBody Comment comment) {
    	return blogRepository.findById(id).map(blog -> {
            comment.setBlog(blog);
            return commentRepository.save(comment);
        }).orElseThrow(() -> new ResourceNotFoundException("Blog ", "id", id));
    }

    @GetMapping("/blogs/{id}/comments")
    public List<Comment> getCommentByBlogId(@PathVariable(value = "id") Long blogId) {
    	
    	if(!blogRepository.existsById(blogId)) {
            throw new ResourceNotFoundException("Blog ", "id", blogId);
        }
    	
    	return commentRepository.findByBlogId(blogId);
    }

    @PutMapping("/comments/{id}")
    public Comment updateComment(@PathVariable(value = "id") Long commentId,
                                           @Valid @RequestBody Comment noteDetails) {

        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("comment", "id", commentId));

        comment.setTitle(noteDetails.getTitle());
        comment.setContent(noteDetails.getContent());

        Comment updatedNote = commentRepository.save(comment);
        return updatedNote;
    }

    @DeleteMapping("/comments/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable(value = "id") Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("comment", "id", commentId));

        commentRepository.delete(comment);

        return ResponseEntity.ok().build();
    }
}
