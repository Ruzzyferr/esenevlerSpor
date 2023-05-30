package com.example.esenevlerSpor.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "Aidat Takibi")
public class AidatTakibi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany
    private List<Kullanici> ogrenciId;

    private String aidatDonemi;

    private String tutar;

}
