package com.example.back.models;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserModel{
    @Id//Decorador para decir que id sera una ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Autoincremental
    @Column(unique = true, nullable = false)//Unique y not null
    private Long id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
