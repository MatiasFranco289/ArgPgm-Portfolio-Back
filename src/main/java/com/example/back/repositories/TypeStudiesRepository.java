package com.example.back.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.back.models.TypeStudiesModel;

@Repository
public interface TypeStudiesRepository extends CrudRepository<TypeStudiesModel, Long>{
    
}
