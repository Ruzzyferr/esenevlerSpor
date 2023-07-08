package com.example.esenevlerSpor.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class SayfaSaveRequestDto {

    private int id;

    private String sayfaAdi;

    private String baslik;

    private String aciklama;

    private boolean aktif = true;

}
