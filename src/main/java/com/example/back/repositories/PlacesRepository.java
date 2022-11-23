package com.example.back.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.back.models.PlacesModel;

public interface PlacesRepository extends CrudRepository<PlacesModel, Long>{
    
}
