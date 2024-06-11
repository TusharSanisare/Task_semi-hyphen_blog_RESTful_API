package com.example.Blog_API.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Blog_API.models.Post;

@Repository
public interface BlogRepo extends JpaRepository<Post, Integer> {

}
