package com.example.back.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "skills")
public class SkillsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_skill;
    @Column(nullable = false)
    private String skill_name;
    @Column(nullable = false)
    @Min(0)
    @Max(100)
    private Integer percentaje;
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
}
