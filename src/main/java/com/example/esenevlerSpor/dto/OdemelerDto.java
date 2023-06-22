package com.example.esenevlerSpor.dto;

import com.example.esenevlerSpor.entity.Kullanici;
import lombok.Data;

import java.util.Date;

@Data
public class OdemelerDto {

    private int id;

    private String baslik;

    private Date odemeTarihi;

    private int tutar;

    private String sebep;


}