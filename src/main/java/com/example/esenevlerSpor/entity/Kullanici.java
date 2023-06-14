package com.example.esenevlerSpor.entity;

import com.example.esenevlerSpor.enums.Role;
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

    private String isim;

    private String soyisim;

    private String yas;

    private Date dogumTarih;

    private String kanGrubu;

    private String mail;

    private String sifre;

    @Enumerated(EnumType.STRING)
    private Role rol;

    private String adres;

    @OneToOne
    private OgrenciDetay ogrenciDetayID;

    private Boolean aktifMi;

}
