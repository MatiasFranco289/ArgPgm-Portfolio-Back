package com.example.back.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.back.repositories.ImagesRepository;

@Service
public class ImagesService {
    @Autowired
    ImagesRepository imagesRepository;

    public void deleteImage(Long id){
        imagesRepository.deleteById(id);
    }
}
