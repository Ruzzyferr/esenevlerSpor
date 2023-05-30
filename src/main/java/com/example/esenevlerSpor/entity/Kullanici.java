package com.example.esenevlerSpor.entity;

import com.example.esenevlerSpor.enums.Cinsiyet;
import com.example.esenevlerSpor.enums.Roles;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "Kullanici")
public class Kullanici {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String tcNo;

    private String name;

    private String surname;

    private String yas;

    private Date dogumTarih;

    private String kanGrubu;

    private String mail;

    private String password;

    @Enumerated(EnumType.STRING)
    private Roles role;

    private String adres;

    @ManyToOne
    private OgrenciDetay ogrenciDetayID;

    private Boolean isActive;

}
