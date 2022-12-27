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

import com.example.back.models.ProjectsModel;
import com.example.back.services.ProjectsService;

@RestController
@RequestMapping("/projects")
public class ProjectsController {
    @Autowired
    ProjectsService projectsService;

    @CrossOrigin(origins = "https://argpgm-portfolio.herokuapp.com")
    @GetMapping
    public ArrayList<ProjectsModel> getProjects(){
        return projectsService.getProjects();
    }

    @CrossOrigin(origins = "https://argpgm-portfolio.herokuapp.com")
    @PostMapping
    public ProjectsModel createProject(@RequestBody ProjectsModel newProject){
        return projectsService.createProject(newProject);
    }

    @CrossOrigin(origins = "https://argpgm-portfolio.herokuapp.com")
    @DeleteMapping(path = "/{id}")
    public void deleteProject(@PathVariable Long id){
        projectsService.deleteProject(id);
    }
}
