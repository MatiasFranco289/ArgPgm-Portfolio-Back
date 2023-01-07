package com.example.back.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.back.models.TypeStudiesModel;
import com.example.back.services.TypeStudiesService;

@RestController
@RequestMapping("/types")
public class TypeStudiesController {
    @Autowired
    TypeStudiesService typeStudiesService;

    @CrossOrigin(origins = "https://argpgm-portfolio.web.app")
    @GetMapping
    public ArrayList<TypeStudiesModel> getTypeStudies(){
        return typeStudiesService.getTypesStudies();
    }

    @CrossOrigin(origins = "https://argpgm-portfolio.web.app")
    @PostMapping TypeStudiesModel createTypeStudy(@RequestBody TypeStudiesModel newStudy){
        return typeStudiesService.createTypeStudy(newStudy);
    }

    @CrossOrigin(origins = "https://argpgm-portfolio.web.app")
    @DeleteMapping(path = "/{id}")
    public void deleteTypeStudy(@PathVariable Long id){
        typeStudiesService.deleteTypeStudy(id);
    }
}
