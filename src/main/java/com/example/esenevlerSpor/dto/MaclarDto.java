package com.example.esenevlerSpor.dto;

import com.example.esenevlerSpor.enums.MacinDurumu;
import lombok.Data;

import java.util.Date;

@Data
public class MaclarDto {

    private int id;

    private String teamOne;

    private String teamTwo;

    private String location;

    private Date date;

    private int skor1;

    private int skor2;

    private MacinDurumu durum;

}