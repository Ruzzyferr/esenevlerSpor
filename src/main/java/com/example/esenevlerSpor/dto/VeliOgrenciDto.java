package com.example.esenevlerSpor.dto;

import com.example.esenevlerSpor.entity.OgrenciDetay;
import lombok.Data;

import javax.persistence.ManyToOne;

@Data
public class VeliOgrenciDto {

    private int id;

    private OgrenciDetay ogrenciId;

}
