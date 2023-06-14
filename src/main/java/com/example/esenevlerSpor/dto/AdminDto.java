package com.example.esenevlerSpor.dto;

import com.example.esenevlerSpor.enums.Role;
import lombok.Data;

@Data
public class AdminDto {

    private int id;

    private String isim;

    private String soyadı;

    private String mail;

    private String sifre;

    private Role rol;

}
