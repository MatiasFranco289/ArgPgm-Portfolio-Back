package com.example.back.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.back.models.PostModel;

@Repository
public interface PostRepository extends CrudRepository<PostModel, Long> {
    
}
