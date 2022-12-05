package com.blog.blogapp.service.impl;

import com.blog.blogapp.entity.Post;
import com.blog.blogapp.exception.ResourceNotFoundException;
import com.blog.blogapp.payload.CommentDto;
import com.blog.blogapp.repository.CommentRepository;
import com.blog.blogapp.repository.PostRepository;
import com.blog.blogapp.service.CommentService;
import com.blog.blogapp.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository , PostRepository postRepository) {
        this.commentRepository=commentRepository;
        this.postRepository=postRepository;
    }


    @Override
    public CommentDto createComment(long post_id , CommentDto commentDto) {
        Comment comment=commentDtoToComment(commentDto);
        if(postRepository.findById(post_id).isPresent()) {
          comment.setPost(postRepository.findById(post_id).get());
          commentRepository.save(comment);
        }
        return  null;
    }





    private Comment commentDtoToComment(CommentDto commentDto) {
       Comment comment=new Comment();
       comment.setId(commentDto.getId());
       comment.setComment(commentDto.getComment());
       comment.setBody(commentDto.getComment());
       comment.setEmail(commentDto.getEmail());
       return comment;
    }

    private CommentDto commentToCommentDto(Comment comment) {
        CommentDto commentDto=new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setComment(comment.getComment());
        commentDto.setBody(comment.getComment());
        commentDto.setEmail(comment.getEmail());
        return commentDto;
    }

}
