package com.example.esenevlerSpor.dto;

import com.example.esenevlerSpor.entity.Kullanici;
import com.example.esenevlerSpor.entity.Takim;
import com.example.esenevlerSpor.enums.Role;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Data
public class KullaniciSaveRequestDTO {

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

    private Boolean aktifMi;

    private Takim takim;

    private String anneAdi;

    private String anneTlf;

    private String anneMeslek;

    private String babaAdi;

    private String babaTlf;

    private String babaMeslek;

    private String uniformNumber;

    private String position;

    private boolean lisans;

    private int aidat;

    private String saatGrubu;

    private String league;

    private Kullanici veli;

}
