package com.example.back.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.back.models.ProjectsModel;

@Repository
public interface ProjectsRepository extends CrudRepository<ProjectsModel, Long> {
    
}
