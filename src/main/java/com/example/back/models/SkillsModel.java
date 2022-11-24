package com.example.back.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "skills")
public class SkillsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_skill;
    @Column(nullable = false, unique = true)
    private String skill_name;
    @Column(nullable = false)
    @Min(0)
    @Max(100)
    private Integer percentaje;

    @JsonIgnore
    @ManyToMany(mappedBy = "skills")
    private Set<ProjectsModel> projects;

    public Long getId_skill() {
        return id_skill;
    }

    public void setId_skill(Long id_skill) {
        this.id_skill = id_skill;
    }

    public String getSkill_name() {
        return skill_name;
    }

    public void setSkill_name(String skill_name) {
        this.skill_name = skill_name;
    }

    public Integer getpercentaje() {
        return percentaje;
    }

    public void setpercentaje(Integer percentaje) {
        this.percentaje = percentaje;
    }

    public Set<ProjectsModel> getProjects() {
        return projects;
    }

    public void setProjects(Set<ProjectsModel> projects) {
        this.projects = projects;
    }
}
