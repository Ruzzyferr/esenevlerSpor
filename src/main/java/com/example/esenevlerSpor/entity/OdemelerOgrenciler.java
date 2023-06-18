package com.example.esenevlerSpor.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "OdemelerOgrenciler")
public class OdemelerOgrenciler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Odemeler odemeler;

    @ManyToOne
    private Kullanici ogrenci;

    private boolean odendiMi = false;

}
