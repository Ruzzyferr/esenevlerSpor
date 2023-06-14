package com.example.esenevlerSpor.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "yoklama")
public class Yoklama {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date gun;

    @ManyToOne
    private Kullanici ogrenci;

}
