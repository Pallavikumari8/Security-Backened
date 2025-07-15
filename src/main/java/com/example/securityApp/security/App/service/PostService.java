package com.example.securityApp.security.App.service;

import com.example.securityApp.security.App.Dto.PostDTO;

import java.util.List;

public interface PostService {
    List<PostDTO> getAllPosts();
    PostDTO createNewPost(PostDTO inputPost);
    PostDTO getPostById(Long postId);
}
