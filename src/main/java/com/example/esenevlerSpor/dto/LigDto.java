package com.example.esenevlerSpor.dto;

import lombok.Data;

import java.util.Date;

@Data
public class LigDto {

    private int id;

    private String ligAdi;

    private String yasGrubu;

    private Date kurulmaTarihi;

    private int oyuncuCount;

}
