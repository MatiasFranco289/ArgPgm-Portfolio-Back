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

import com.example.back.models.SkillsModel;
import com.example.back.services.SkillsService;

@RestController
@RequestMapping("/skills")
public class SkillsController {
    @Autowired
    SkillsService skillService;

    @CrossOrigin(origins = "https://argpgm-portfolio.herokuapp.com")
    @GetMapping//Obtiene todas las habilidades
    public ArrayList<SkillsModel> getSkills(){
        return skillService.getSkills();
    }

    @CrossOrigin(origins = "https://argpgm-portfolio.herokuapp.com")
    @PostMapping
    public SkillsModel createSkill(@RequestBody SkillsModel skill){
        return skillService.createSkill(skill);
    }

    @CrossOrigin(origins = "https://argpgm-portfolio.herokuapp.com")
    @DeleteMapping(path = "/{id}")//Recibe una id por params y elimina esa habilidad
    public void deleteById(@PathVariable("id") Long id){
        skillService.deleteSkill(id);
    }
}
