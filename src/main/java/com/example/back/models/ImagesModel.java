package com.example.back.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "images")
public class ImagesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_image;
    @JsonBackReference//Eso es necesario pone el mouse ensima para ver que hacer
    @ManyToOne(fetch = FetchType.LAZY)//Aca defino que esta tabla tiene una relacion muchos a uno
    @JoinColumn(name = "id_post")//Esto crea una columna en esta tabla llamada "id_post" donde guardara el id del post al que pertencera esta imagen(Basicamente un FK)
    private PostModel post;


    @Column(nullable = false)
    private String imgUrl;

    public Long getId_image() {
        return id_image;
    }

    public void setId_image(Long id_image) {
        this.id_image = id_image;
    }

    public PostModel getPost() {
        return post;
    }

    public void setPost(PostModel post) {
        this.post = post;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
