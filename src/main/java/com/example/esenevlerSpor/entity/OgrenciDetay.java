package com.example.esenevlerSpor.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
@Entity
@Table(name = "OgrenciDetay")
public class OgrenciDetay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String anneAdi;

    private String anneTlf;

    private String anneMeslek;

    private String babaAdi;

    private String babaTlf;

    private String babaMeslek;

    private String uniformNumber;

    private String position;

    @ManyToOne
    private Takim takim;

    private String league;

    @ManyToOne
    private Kullanici veli;

    @OneToMany
    private List<Files> files;
}
