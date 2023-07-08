package com.example.esenevlerSpor.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

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

    private Date odenmeTarihi;

    public boolean odendiMi = false;

}
