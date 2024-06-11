package com.example.Blog_API.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Blog_API.models.Post;
import com.example.Blog_API.repositories.BlogRepo;

@Service
public class BlogService {

  @Autowired
  private BlogRepo blogRepo;

  public Post createPost(Post post) {
    return blogRepo.save(post);
  }

  public List<Post> getAllPosts() {
    return blogRepo.findAll();
  }

  public Optional<Post> getPostById(int id) {
    return blogRepo.findById(id);
  }

  public Post updatePost(int id, Post postDetails) {
    Post post = blogRepo.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
    post.setTitle(postDetails.getTitle());
    post.setContent(postDetails.getContent());
    return blogRepo.save(post);
  }

  public void deletePost(int id) {
    blogRepo.deleteById(id);
  }

}
