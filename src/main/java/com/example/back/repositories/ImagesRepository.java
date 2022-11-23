package com.example.back.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.back.models.ImagesModel;

@Repository
public interface ImagesRepository extends CrudRepository<ImagesModel, Long> {
    
}
