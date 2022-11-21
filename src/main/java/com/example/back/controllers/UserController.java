package com.example.back.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.back.models.UserModel;
import com.example.back.services.UserService;

// Todo inicia por el controlador, donde se recibe la peticion web e inmediatamente despues
// manda a llamar a un servicio (UserServices en este caso)

@RestController
@RequestMapping("/users")//Defino la ruta
public class UserController {
    @Autowired
    UserService userService;

    //Cuando llegue una peticion get quiero que haga esto
    @GetMapping()
    public ArrayList<UserModel> getUsers(){
        return userService.getUsers();
    }

    @PostMapping
    public UserModel createUser(@RequestBody UserModel user){
        return this.userService.createUser(user);
    }
}
