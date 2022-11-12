package com.blog.blogapp.Repository;

import com.blog.blogapp.entity.Post;
import com.blog.blogapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface PostRepository extends JpaRepository<Post,Long> {
}
