package com.example.esenevlerSpor.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "sayfa")
public class Sayfa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String sayfaAdi;

    private String baslik;

    private String aciklama;

    //foto gelicek

    private boolean aktif = true;

}
