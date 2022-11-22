package com.example.back.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.back.models.SkillsModel;

@Repository
public interface SkillsRepository extends CrudRepository<SkillsModel, Long> {
    
}
