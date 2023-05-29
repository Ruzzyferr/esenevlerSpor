package com.example.esenevlerSpor.dto;

import com.example.esenevlerSpor.entity.OgrenciDetay;
import com.example.esenevlerSpor.enums.Cinsiyet;
import com.example.esenevlerSpor.enums.Roles;
import lombok.Data;

import java.util.Date;

@Data
public class KullaniciSaveRequestDTO {

    private int id;

    private String tcNo;

    private String name;

    private String surname;

    private String yas;

    private Date dogumTarih;

    private String mail;

    private String password;

    private Roles role;

    private String anneAdi;

    private String anneTlf;

    private String anneMeslek;

    private String babaAdi;

    private String babaTlf;

    private String babaMeslek;

    private String adres;

    private OgrenciDetay ogrenciDetayID;

    private Boolean isActive;

}
