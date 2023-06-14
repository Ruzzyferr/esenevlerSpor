package com.example.esenevlerSpor.dto;

import com.example.esenevlerSpor.entity.OgrenciDetay;
import com.example.esenevlerSpor.enums.Role;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
public class KullaniciDto {

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

    private OgrenciDetay ogrenciDetayID;

    private Boolean aktifMi;

}
