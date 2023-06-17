package com.example.esenevlerSpor.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "Odemeler")
public class Odemeler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany
    private List<Kullanici> ogrenci;

    private int donem;

    private int toplamFiyat;

}
