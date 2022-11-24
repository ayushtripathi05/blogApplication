package com.blog.blogapp.controller;


import com.blog.blogapp.payload.CommentDto;
import com.blog.blogapp.payload.PostDto;
import com.blog.blogapp.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    CommentService commentService;

    public  CommentController(CommentService commentService) {
        this.commentService=commentService;
    }

    @PostMapping
    public ResponseEntity<CommentDto> createPost(@RequestBody CommentDto commentDto) {
        return  new ResponseEntity<>(commentService.createComment(commentDto), HttpStatus.CREATED);
    }




}
