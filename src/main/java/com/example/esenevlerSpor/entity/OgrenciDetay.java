package com.example.esenevlerSpor.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name = "OgrenciDetay")
public class OgrenciDetay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String uniformNumber;

    private String position;

   private String team;

    private String league;

    @ManyToOne
    private Kullanici anne;

    @ManyToOne
    private Kullanici baba;


    @ManyToOne
    private Files files;
}
