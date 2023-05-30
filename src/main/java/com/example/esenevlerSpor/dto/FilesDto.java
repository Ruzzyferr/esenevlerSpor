package com.example.esenevlerSpor.dto;

import com.example.esenevlerSpor.entity.OgrenciDetay;
import lombok.Data;


@Data
public class FilesDto {

    private int id;

    private OgrenciDetay ogrenciId;

    private String name;

    private String dosyaKategori;

}
