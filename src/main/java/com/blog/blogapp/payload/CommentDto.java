package com.blog.blogapp.payload;

import lombok.Data;

@Data
public class CommentDto {
    private long id;
    private String comment;
    private String email;
    private String body;
}
