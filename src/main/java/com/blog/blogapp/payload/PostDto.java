package com.blog.blogapp.payload;

import lombok.Data;

import javax.persistence.Entity;

@Data
public class PostDto {
    private long id;
    private  String title;
    private  String content;
    private  String description;
}
