package com.example.back.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.back.models.StudiesModel;

@Repository
public interface StudiesRepository extends CrudRepository<StudiesModel, Long> {
    
}
