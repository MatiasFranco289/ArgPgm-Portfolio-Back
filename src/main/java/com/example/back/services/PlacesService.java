package com.example.back.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.back.models.PlacesModel;
import com.example.back.repositories.PlacesRepository;

@Service
public class PlacesService {
    @Autowired
    PlacesRepository placesRepository;

    public ArrayList<PlacesModel> getPlaces(){
        return (ArrayList<PlacesModel>)placesRepository.findAll();
    }

    public PlacesModel createPlace(PlacesModel place){
        return placesRepository.save(place);
    }

    public void deletePlace(Long id){
        placesRepository.deleteById(id);
    }
}
