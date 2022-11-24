package com.blog.blogapp.service.impl;

import com.blog.blogapp.payload.CommentDto;
import com.blog.blogapp.repository.CommentRepository;
import com.blog.blogapp.service.CommentService;
import com.blog.blogapp.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;


public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository=commentRepository;
    }


    @Override
    public CommentDto createComment(CommentDto commentDto) {
      return commentToCommentDto(this.commentRepository.save(commentDtoToComment(commentDto)));
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
