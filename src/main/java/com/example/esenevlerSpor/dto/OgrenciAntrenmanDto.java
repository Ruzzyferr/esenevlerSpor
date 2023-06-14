package com.example.esenevlerSpor.dto;

import com.example.esenevlerSpor.entity.Antrenmanlar;
import com.example.esenevlerSpor.entity.Kullanici;
import com.example.esenevlerSpor.entity.OgrenciDetay;
import lombok.Data;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Data
public class OgrenciAntrenmanDto {

    private int id;

    private Kullanici ogrenciId;

    private Antrenmanlar antrenman;

    private Boolean isDone;

    private String aciklama;

    private int not;

}
