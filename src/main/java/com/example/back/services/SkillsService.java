package com.example.back.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.back.models.SkillsModel;
import com.example.back.repositories.SkillsRepository;

@Service
public class SkillsService {
    @Autowired
    SkillsRepository skillRepository;

    public ArrayList<SkillsModel> getSkills(){
        return (ArrayList<SkillsModel>) skillRepository.findAll();
    }

    public SkillsModel createSkill(SkillsModel skill){
        return skillRepository.save(skill);
    }

    public void deleteSkill(Long id){
        skillRepository.deleteById(id);
    }
}

