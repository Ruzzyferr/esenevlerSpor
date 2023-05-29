package com.example.esenevlerSpor.dto;

import lombok.Data;

import java.util.Date;

@Data
public class OgrenciDetayDto {

    private int id;

    private String uniformNumber;

    private String position;

    private Date startingDate;

    private int age;

    private String league;

}
