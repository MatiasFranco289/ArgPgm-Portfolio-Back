package com.example.back.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.back.models.StudiesModel;
import com.example.back.services.StudiesService;

@RestController
@RequestMapping("/studies")
public class StudiesController {
    @Autowired
    StudiesService studiesService;

    @PutMapping
    public StudiesModel editStudy(@RequestBody StudiesModel newInfo){
        return studiesService.editStudy(newInfo);
    }

    @DeleteMapping("/{id}")
    public void deleteStudy(@PathVariable Long id){
        studiesService.deleteStudy(id);
    }

}
