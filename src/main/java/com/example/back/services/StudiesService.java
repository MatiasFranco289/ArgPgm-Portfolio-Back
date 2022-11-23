package com.example.back.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.back.models.StudiesModel;
import com.example.back.repositories.StudiesRepository;

@Service
public class StudiesService {
    @Autowired
    StudiesRepository studiesRepository;

    public void deleteStudy(Long id){
        studiesRepository.deleteById(id);
    }

    public StudiesModel editStudy(StudiesModel newInfo){
        if(!studiesRepository.existsById(newInfo.getId_study())) return null;//Si el id no corresponde a un estudio existente no hago nada
        return studiesRepository.save(newInfo);//Si el id existe edito el estudio
    }
}
