package com.example.back.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.back.models.UserModel;

// El repositorio utiliza el modelo para saber que tipo de informacion va a traer

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long>{// Esto sera una interfaz que exitiende de CrudRepostitory, indicandole el modelo y el tipo de la PK
    UserModel findByUsername(String name);
    Boolean existsByUsername(String name);
}
