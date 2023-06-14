package com.example.esenevlerSpor.entity;

import com.example.esenevlerSpor.enums.AntrenmanKategori;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "Antrenmanlar")
public class Antrenmanlar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date tarih;

    private AntrenmanKategori kategori;

    private String lokasyon;

    private String durum;

}
