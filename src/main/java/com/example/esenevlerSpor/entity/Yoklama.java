package com.example.esenevlerSpor.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "Yoklama")
public class Yoklama {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date tarih;

    @ManyToOne
    private Kullanici ogrenci;

    private boolean geldiMi=false;


}
