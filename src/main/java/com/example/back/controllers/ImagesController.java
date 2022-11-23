package com.example.back.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.back.services.ImagesService;

@RestController
@RequestMapping("/images")
public class ImagesController {
    @Autowired
    ImagesService imagesService;

    @DeleteMapping(path = "/{id}")
    public void deleteImage(@PathVariable Long id){
        imagesService.deleteImage(id);
    }
}
