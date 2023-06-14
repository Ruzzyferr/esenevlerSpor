package com.example.esenevlerSpor.dto;

import com.example.esenevlerSpor.entity.Kullanici;
import lombok.Data;


@Data
public class FilesDto {

    private int id;

    private Kullanici ogrenci;

    private String name;

    private String dosyaKategori;

}
