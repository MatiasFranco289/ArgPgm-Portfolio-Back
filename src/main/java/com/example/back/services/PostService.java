package com.example.back.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.back.models.PostModel;
import com.example.back.repositories.PostRepository;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public ArrayList<PostModel> getPosts(){
        return(ArrayList<PostModel>) postRepository.findAll();
    }

    public PostModel createPost(PostModel newPost){
        return postRepository.save(newPost);
    }
}
