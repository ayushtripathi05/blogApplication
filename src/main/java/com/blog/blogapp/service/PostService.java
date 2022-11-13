package com.blog.blogapp.service;

import com.blog.blogapp.payload.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto);
    List<PostDto> getAllPost();

}
