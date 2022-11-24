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

import com.example.back.models.UserModel;
import com.example.back.services.UserService;

// Todo inicia por el controlador, donde se recibe la peticion web e inmediatamente despues
// manda a llamar a un servicio (UserServices en este caso)

@RestController
@RequestMapping("/users")//Defino la ruta
public class UserController {
    @Autowired
    UserService userService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/all")//Esto representa una ruta get
    public ArrayList<UserModel> getAllUsers(){//Devuelve una lista de usuarios ocultando la contrase;a
        return userService.getAllUsers();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping()
    public Boolean checkUser(@RequestBody UserModel user){//Verifica credenciales y devuelve un bool
        return userService.checkCredentials(user);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public UserModel createUser(@RequestBody UserModel user){//Crea un usuario nuevo
        return this.userService.createUser(user);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(path = "/{id}")
    public void deleteUser(@PathVariable Long id){
        this.userService.deleteUser(id);
    }
}
