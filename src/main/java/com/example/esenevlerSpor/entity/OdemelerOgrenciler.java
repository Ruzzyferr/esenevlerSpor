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
    public Odemeler odemeler;

    @ManyToOne
    public Kullanici ogrenci;

    public boolean odendiMi = false;

}
