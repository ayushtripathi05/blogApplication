package com.blog.blogapp.controller;


import com.blog.blogapp.payload.CommentDto;
import com.blog.blogapp.payload.PostDto;
import com.blog.blogapp.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/posts/")
public class CommentController {
    CommentService commentService;

    public  CommentController(CommentService commentService) {
        this.commentService=commentService;
    }

    @PostMapping(path = "{id}/comments/")
    public ResponseEntity<CommentDto> createComment(@PathVariable(name = "id") long id, @RequestBody CommentDto commentDto) {
        return  new ResponseEntity<>(commentService.createComment(id , commentDto), HttpStatus.CREATED);
    }

}
