package com.example.back.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.back.models.ExperiencesModel;
import com.example.back.repositories.ExperiencesRepository;

@Service
public class ExperiencesService {
    @Autowired
    ExperiencesRepository experiencesRepository;

    public void deleteExperience(Long id){
        experiencesRepository.deleteById(id);
    }

    public ExperiencesModel editExperience(ExperiencesModel newInfo){
        if(!experiencesRepository.existsById(newInfo.getId_experience())) return null;
        return experiencesRepository.save(newInfo);
    }
}
