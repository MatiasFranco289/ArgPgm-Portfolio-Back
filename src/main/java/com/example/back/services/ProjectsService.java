package com.example.back.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.back.models.ProjectsModel;
import com.example.back.repositories.ProjectsRepository;

@Service
public class ProjectsService {
    @Autowired
    ProjectsRepository projectsRepository;

    public ArrayList<ProjectsModel> getProjects(){
        return (ArrayList<ProjectsModel>)projectsRepository.findAll();
    }

    public ProjectsModel createProject(ProjectsModel newProject){
        return projectsRepository.save(newProject);
    }

    public void deleteProject(Long id){
        projectsRepository.deleteById(id);
    }
}
