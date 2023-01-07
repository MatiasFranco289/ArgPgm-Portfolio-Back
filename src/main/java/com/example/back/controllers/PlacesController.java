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

import com.example.back.models.PlacesModel;
import com.example.back.services.PlacesService;

@RestController
@RequestMapping("/places")
public class PlacesController {
    @Autowired
    PlacesService placesService;

    @CrossOrigin(origins = "https://argpgm-portfolio.web.app")
    @GetMapping
    public ArrayList<PlacesModel> getPlaces(){
        return placesService.getPlaces();
    }

    @CrossOrigin(origins = "https://argpgm-portfolio.web.app")
    @PostMapping
    public PlacesModel createPlace(@RequestBody PlacesModel place){
        return placesService.createPlace(place);
    }

    @CrossOrigin(origins = "https://argpgm-portfolio.web.app")
    @DeleteMapping(path = "/{id}")
    public void deletePlace(@PathVariable Long id){
        placesService.deletePlace(id);
    }
}
