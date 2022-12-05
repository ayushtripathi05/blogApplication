package com.blog.blogapp.service;

import com.blog.blogapp.entity.Comment;
import com.blog.blogapp.payload.CommentDto;
import lombok.Data;


public interface CommentService {

    CommentDto createComment(long post_id , CommentDto commentDto);





}
