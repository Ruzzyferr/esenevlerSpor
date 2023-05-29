package com.example.esenevlerSpor.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "webpage")
public class Webpage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100)
    private String baslik;

    private String aciklama;

}
