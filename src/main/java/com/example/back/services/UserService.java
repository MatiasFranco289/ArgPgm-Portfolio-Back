package com.example.back.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.back.models.UserModel;
import com.example.back.repositories.UserRepository;

import java.util.ArrayList;

@Service
public class UserService {
    @Autowired//Esto hace que no tengamos que instanciar, UserRepository, le dice a spring que ya existe una instancia y cual utilizar
    UserRepository userRepository;

    public ArrayList<UserModel> getAllUsers(){
        ArrayList<UserModel> userList = (ArrayList<UserModel>) userRepository.findAll();

        for(UserModel user:userList){ user.setPassword("****");}

        return userList;
    }

    public Boolean checkCredentials(UserModel user){
        if(!userRepository.existsByUsername(user.getUsername())) return false;

        UserModel userCredentials = userRepository.findByUsername(user.getUsername());

        return user.getPassword().equals(userCredentials.getPassword());
    }

    public UserModel createUser(UserModel user){
        return userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}


