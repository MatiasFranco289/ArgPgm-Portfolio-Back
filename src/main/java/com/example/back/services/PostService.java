package com.example.back.services;

import java.util.ArrayList;
import java.util.Optional;

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

    public Optional<PostModel> getPostById(Long id){
        return postRepository.findById(id);
    }

    public PostModel createPost(PostModel newPost){
        Long postId = newPost.getId_post();

        //Si esto es diferente de null es porque me mandaron una ID y por ende quieren editar un registro existente
        //Por lo tanto si el id que me dieron corresponde a un post existente, obtengo su fecha de creacion y la asigno
        //Todo esto es necesario porque sino la fecha de creacion se actualiza cuanda edita un post ya existente lo cual mo deberia pasar
        if(postId != null && postRepository.existsById(postId)){
            Optional<PostModel> oldPostOptional = postRepository.findById(postId);
            PostModel oldPost = oldPostOptional.get();
            newPost.setCreatedAt(oldPost.getCreatedAt());
        }
        return postRepository.save(newPost);
    }

    public void deletePost(Long id){
        postRepository.deleteById(id);
    }
}
