package com.blog.blogapp.service;

import com.blog.blogapp.entity.Comment;
import com.blog.blogapp.payload.CommentDto;

public interface CommentService {

    CommentDto createComment(CommentDto commentDto);

}
