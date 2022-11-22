package com.example.back.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping//Obtiene todas las habilidades
    public ArrayList<SkillsModel> getSkills(){
        return skillService.getSkills();
    }

    // Crea una habilidad, o si se le pasa una id, edita una existente, recibe todo por body
    // Error 1: percentaje no existe
    // Error 2: percentaje no es un numero
    // Error 3: percentaje se sale de los limites
    // Error 4: skill_name no existe
    // Error 5: skill_name no es un string
    // Error 6: skill_name es empty
    @PostMapping
    public SkillsModel createSkill(@RequestBody SkillsModel skill){
        return skillService.createSkill(skill);
    }

    @DeleteMapping(path = "/{id}")//Recibe una id por params y elimina esa habilidad
    public void deleteById(@PathVariable("id") Long id){
        skillService.deleteSkill(id);
    }
}
