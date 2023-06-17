package com.example.esenevlerSpor.dto;

import com.example.esenevlerSpor.entity.Kullanici;
import lombok.Data;

import java.util.List;

@Data
public class OdemelerSaveRequestDto {

    private int id;

    private int donem;

    private int toplamFiyat;

}
