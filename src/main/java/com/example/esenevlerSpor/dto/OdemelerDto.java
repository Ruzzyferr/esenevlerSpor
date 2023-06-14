package com.example.esenevlerSpor.dto;

import com.example.esenevlerSpor.entity.Kullanici;
import lombok.Data;

@Data
public class OdemelerDto {

    private int id;

    private Kullanici ogrenci;

    private int donem;

    private int toplamFiyat;

    private boolean odendiMi;

}