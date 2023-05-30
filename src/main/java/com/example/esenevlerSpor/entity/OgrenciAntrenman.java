package com.example.esenevlerSpor.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Ogrenci Antrenman")
public class OgrenciAntrenman {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Kullanici ogrenciId;

    @OneToOne
    private Antrenmanlar antrenman;

    private Boolean isDone;

    private String aciklama;

    private int not;


}
