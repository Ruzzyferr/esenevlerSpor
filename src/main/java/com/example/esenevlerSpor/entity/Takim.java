package com.example.esenevlerSpor.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "Takimlar")
public class Takim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String takimAdi;

    private String lig;

    private Date kurulmaTarih;

    @OneToMany
    private List<Kullanici> kullanici;

}
