package com.example.back.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "places")
public class PlacesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id_place;
    @Column(nullable = false)
    private String location;
    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "place", cascade = CascadeType.ALL)
    List<ExperiencesModel> experiences;

    public Long getId_place() {
        return id_place;
    }

    public void setId_place(Long id_place) {
        this.id_place = id_place;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<ExperiencesModel> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<ExperiencesModel> experiences) {
        this.experiences = experiences;
    }
}
