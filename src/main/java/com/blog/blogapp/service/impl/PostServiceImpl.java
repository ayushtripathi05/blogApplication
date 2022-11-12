package com.blog.blogapp.service.impl;

import com.blog.blogapp.entity.Post;
import com.blog.blogapp.payload.PostDto;
import com.blog.blogapp.repository.PostRepository;
import com.blog.blogapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    @Autowired
    public  PostServiceImpl(PostRepository postRepository) {
        this.postRepository=postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post=new Post();
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());
        return null;
    }
}
