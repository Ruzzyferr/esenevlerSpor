package com.example.esenevlerSpor.dto;

import com.example.esenevlerSpor.entity.Kullanici;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class YoklamaAlDto {

    private Date date;

    private List<Kullanici> kullanicis;
}
