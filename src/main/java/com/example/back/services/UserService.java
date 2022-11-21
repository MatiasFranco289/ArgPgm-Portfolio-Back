package com.example.back.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.back.models.UserModel;
import com.example.back.repositories.UserRepository;

@Service
public class UserService {
    @Autowired//Esto hace que no tengamos que instanciar, UserRepository, le dice a spring que ya existe una instancia y cual utilizar
    UserRepository userRepository;

    public ArrayList<UserModel> getUsers(){
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel createUser(UserModel user){
        return userRepository.save(user);
    }
}


