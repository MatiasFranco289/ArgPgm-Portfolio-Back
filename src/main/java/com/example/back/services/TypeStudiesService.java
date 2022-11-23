package com.example.back.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.back.models.TypeStudiesModel;
import com.example.back.repositories.TypeStudiesRepository;

@Service
public class TypeStudiesService {
    @Autowired
    TypeStudiesRepository typeStudiesRepository;

    public ArrayList<TypeStudiesModel> getTypesStudies(){
        return (ArrayList<TypeStudiesModel>)typeStudiesRepository.findAll();
    }

    public TypeStudiesModel createTypeStudy(TypeStudiesModel newType){
        return typeStudiesRepository.save(newType);
    }

    public void deleteTypeStudy(Long id){
        typeStudiesRepository.deleteById(id);
    }
}
