package com.example.back.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.back.models.ExperiencesModel;
import com.example.back.services.ExperiencesService;

@RestController
@RequestMapping("/experiences")
public class ExperiencesController {
    @Autowired
    ExperiencesService experiencesService;
    
    @CrossOrigin(origins = "https://argpgm-portfolio.web.app")
    @DeleteMapping(path = "/{id}")
    public void deleteExperience(@PathVariable Long id){
        experiencesService.deleteExperience(id);
    }

    @CrossOrigin(origins = "https://argpgm-portfolio.web.app")
    @PutMapping
    public ExperiencesModel editExperience(@RequestBody ExperiencesModel newInfo){
        return experiencesService.editExperience(newInfo);
    }
}
