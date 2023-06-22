package com.example.esenevlerSpor.entity;

import com.example.esenevlerSpor.enums.Role;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    private String dogumYeri;

    private String kanGrubu;

    private String mail;

    private String sifre;

    @Enumerated(EnumType.STRING)
    private Role rol;

    private String adres;

    private boolean servisVarMi;

    private String anneAdi;

    private String anneTlf;

    private String anneMeslek;

    private String babaAdi;

    private String babaTlf;

    private String babaMeslek;

    private String formaNum;

    private String mevki;

    private boolean lisans;

    private int aidat;

    private String saatGrubu;

    private String lig;

    @ManyToOne
    private Kullanici veli;

    private Boolean aktifMi;

    @OneToMany(mappedBy = "ogrenci", fetch = FetchType.LAZY)
    private List<OdemelerOgrenciler> odemelerOgrenciler;


}
