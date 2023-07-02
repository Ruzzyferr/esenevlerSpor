package com.example.esenevlerSpor.dto;

import lombok.Data;

import java.util.Date;

@Data
public class LigSaveRequestDto {

    private int id;

    private String ligAdi;

    private String yasGrubu;

    private Date kurulmaTarihi;

}
