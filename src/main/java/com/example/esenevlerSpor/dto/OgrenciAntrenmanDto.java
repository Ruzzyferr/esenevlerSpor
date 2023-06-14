package com.example.esenevlerSpor.dto;

import com.example.esenevlerSpor.entity.Antrenmanlar;
import com.example.esenevlerSpor.entity.Kullanici;
import lombok.Data;

@Data
public class OgrenciAntrenmanDto {

    private int id;

    private Kullanici ogrenci;

    private Antrenmanlar antrenman;

    private Boolean isDone;

    private String aciklama;

    private int not;

}
