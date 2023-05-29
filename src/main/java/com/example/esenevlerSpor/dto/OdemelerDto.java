package com.example.esenevlerSpor.dto;

import com.example.esenevlerSpor.entity.OgrenciDetay;
import lombok.Data;

@Data
public class OdemelerDto {

    private int id;

    private OgrenciDetay ogrenciId;

    private int donem;

    private int totalPrice;

    private boolean isPaid;

}