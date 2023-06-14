package com.example.esenevlerSpor.dto;

import com.example.esenevlerSpor.enums.AntrenmanKategori;
import lombok.Data;

import java.util.Date;

@Data
public class AntrenmanlarDto {

    private int id;

    private Date tarih;

    private AntrenmanKategori kategori;

    private String lokasyon;

    private String durum;

}
