package com.example.esenevlerSpor.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MaclarDto {

    private int id;

    private String teamOne;

    private String teamTwo;

    private String location;

    private Date date;

    private int Score;

    private boolean didWin;

    private boolean isPlayed;

}