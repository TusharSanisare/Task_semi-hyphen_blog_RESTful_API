package com.example.Blog_API.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Blog_API.models.Post;
import com.example.Blog_API.services.BlogService;

@RestController
@RequestMapping("/api/posts")
public class BlogController {

  @Autowired
  private BlogService blogService;

  @PostMapping
  public ResponseEntity<Post> createPost(@RequestBody Post post) {
    return ResponseEntity.ok(blogService.createPost(post));
  }

  @GetMapping
  public ResponseEntity<List<Post>> getAllPosts() {
    return ResponseEntity.ok(blogService.getAllPosts());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Post> getPostById(@PathVariable int id) {
    return blogService.getPostById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @PutMapping("/{id}")
  public ResponseEntity<Post> updatePost(@PathVariable int id, @RequestBody Post postDetails) {
    return ResponseEntity.ok(blogService.updatePost(id, postDetails));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletePost(@PathVariable int id) {
    blogService.deletePost(id);
    return ResponseEntity.noContent().build();
  }

}
