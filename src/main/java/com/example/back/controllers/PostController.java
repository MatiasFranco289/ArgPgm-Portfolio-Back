package com.example.back.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.back.models.PostModel;
import com.example.back.services.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired 
    PostService postService;

    @GetMapping()
    public ArrayList<PostModel> getPosts(){
        return postService.getPosts();
    }

    @PostMapping()
    public PostModel createPost(@RequestBody PostModel newPost){
        return postService.createPost(newPost);
    }
}
