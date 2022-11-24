package com.blog.blogapp.service;

import com.blog.blogapp.entity.Post;
import com.blog.blogapp.payload.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto);
    List<PostDto> getAllPost();
    PostDto getPostById(long id);
    PostDto updatePostById(PostDto postDto , long id);
    PostDto deletePostById(long id);
}
