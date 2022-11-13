package com.blog.blogapp.service.impl;

import com.blog.blogapp.entity.Post;
import com.blog.blogapp.payload.PostDto;
import com.blog.blogapp.repository.PostRepository;
import com.blog.blogapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    @Autowired
    public  PostServiceImpl(PostRepository postRepository) {
        this.postRepository=postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        return postToPostDto(postRepository.save(PostDtoToPost(postDto)));
    }


    @Override
    public List<PostDto> getAllPost() {
        List<PostDto> listPostDto=new ArrayList<>();
        List<Post> listPost=postRepository.findAll();
        for(Post post : listPost) {
            listPostDto.add(postToPostDto(post));
        }
        return listPostDto;
    }




    private PostDto postToPostDto(Post post) {
        PostDto postDto=new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getDescription());
        return postDto;
    }

    private Post PostDtoToPost(PostDto postDto) {
        Post post=new Post();
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getDescription());
        return post;

    }

}
