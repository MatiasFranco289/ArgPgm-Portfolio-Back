package com.example.back.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.back.models.ExperiencesModel;

@Repository
public interface ExperiencesRepository extends CrudRepository<ExperiencesModel, Long> {
    
}
