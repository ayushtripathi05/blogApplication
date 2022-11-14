package com.blog.blogapp.service.impl;

import com.blog.blogapp.entity.Post;
import com.blog.blogapp.exception.ResourceNotFoundException;
import com.blog.blogapp.payload.PostDto;
import com.blog.blogapp.repository.PostRepository;
import com.blog.blogapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public PostDto getPostById(long id) {
        Optional<Post> post= Optional.ofNullable(postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("post", "id", String.valueOf(id))));
        return postToPostDto(post.get());
    }

    @Override
    public PostDto updatePostById(PostDto postDto, long id) {
        Optional<Post> post= Optional.ofNullable(postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("post", "id", String.valueOf(id))));
        post.get().setDescription(postDto.getDescription());
        post.get().setTitle(postDto.getTitle());
        post.get().setContent(postDto.getContent());
        return postToPostDto(postRepository.save(post.get()));
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
