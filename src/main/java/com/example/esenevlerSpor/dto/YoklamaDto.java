package com.example.esenevlerSpor.dto;

import com.example.esenevlerSpor.entity.Kullanici;
import lombok.Data;

import javax.persistence.ManyToOne;
import java.util.Date;

@Data
public class YoklamaDto {

    private int id;

    private Date tarih;

    private Kullanici ogrenci;

    private boolean geldiMi=false;

}
