package com.example.esenevlerSpor.dto;

import com.example.esenevlerSpor.entity.Kullanici;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OdemelerSaveRequestDto {

    private int id;

    private String baslik;

    private Date odemeTarihi;

    private int tutar;

    private String sebep;

}
