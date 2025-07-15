package com.example.securityApp.security.App.service;

import com.example.securityApp.security.App.Dto.PostDTO;
import com.example.securityApp.security.App.Entity.PostEntity;
import com.example.securityApp.security.App.Exception.ResourceNotFoundException;
import com.example.securityApp.security.App.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.ast.tree.expression.Collation;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{
    private final PostRepository postRepository;
    private final ModelMapper  modelMapper;

    @Override
    public List<PostDTO> getAllPosts(){
        return postRepository
                .findAll()
                .stream()
                .map(postEntity -> modelMapper.map(postEntity,PostDTO.class))
                .collect(Collectors.toList());
    }
    @Override
    public PostDTO createNewPost(PostDTO inputPost){
        PostEntity postEntity=modelMapper.map(inputPost,PostEntity.class);
        return modelMapper.map(postRepository.save(postEntity),PostDTO.class);
    }
    public PostDTO getPostById(Long postId){
        PostEntity postEntity=postRepository
                .findById(postId)
                .orElseThrow(()-> new ResourceNotFoundException("Post not found with id:"+postId));
        return modelMapper.map(postEntity,PostDTO.class);
    }

}
