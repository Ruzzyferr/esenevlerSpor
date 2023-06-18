package com.example.esenevlerSpor.dto;

import com.example.esenevlerSpor.entity.Kullanici;
import com.example.esenevlerSpor.entity.Odemeler;
import lombok.Data;

import javax.persistence.ManyToOne;

@Data
public class OdemeYapDto {

    private Odemeler odemeler;

    private Kullanici ogrenci;

}
