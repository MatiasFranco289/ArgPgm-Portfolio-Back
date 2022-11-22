package com.example.back.models;

import java.util.List;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "posts")
public class PostModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_post;
    @Column(nullable = false)
    private String title;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date createdAt;
    @Column(nullable = false)
    private String description;

    //Aca defino una relacion de uno a muchos, UN post puede tener MUCHAS images
    //FechType.LAZY significa que solo quiero que utilize los recursos cuando haga un fetch pidiendo las imagenes, si no pido las imagenes en mi consultas no me interesa
    //MappedBy no crea ninguna campo, pero define que "post" es el nombre del atributo que escribi en la parte de los muchos(En ImagesModel hay un atributo llamado post)
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "post", cascade = CascadeType.ALL)
    List<ImagesModel> images;

    @PrePersist
    private void onCreate(){
        createdAt = new Date();
    }

    public Long getId_post() {
        return id_post;
    }

    public void setId_post(Long id_post) {
        this.id_post = id_post;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
