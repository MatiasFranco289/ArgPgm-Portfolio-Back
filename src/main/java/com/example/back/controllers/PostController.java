package com.example.back.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @CrossOrigin(origins = "https://argpgm-portfolio.herokuapp.com")
    @GetMapping()//Obtener todos los posteos
    public ArrayList<PostModel> getPosts(){
        return postService.getPosts();
    }

    @CrossOrigin(origins = "https://argpgm-portfolio.herokuapp.com")
    @GetMapping(path = "/{id}")
    public Optional<PostModel> getPostById(@PathVariable Long id){
        return postService.getPostById(id);
    }

    @CrossOrigin(origins = "https://argpgm-portfolio.herokuapp.com")
    @PostMapping()//Crear un posteo
    public PostModel createPost(@RequestBody PostModel newPost){
        return postService.createPost(newPost);
    }

    @CrossOrigin(origins = "https://argpgm-portfolio.herokuapp.com")
    @DeleteMapping(path = "/{id}")//Eliminar un posteo
    public void deletePost(@PathVariable Long id){
        postService.deletePost(id);
    }
}
