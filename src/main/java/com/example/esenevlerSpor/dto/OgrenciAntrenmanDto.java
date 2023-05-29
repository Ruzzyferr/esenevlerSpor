package com.example.esenevlerSpor.dto;

import com.example.esenevlerSpor.entity.Antrenmanlar;
import com.example.esenevlerSpor.entity.OgrenciDetay;
import lombok.Data;

@Data
public class OgrenciAntrenmanDto {

    private int id;

    private OgrenciDetay ogrenciId;

    private Antrenmanlar antrenmanId;

    private boolean isDone;

}
