package com.example.esenevlerSpor.entity;


import com.example.esenevlerSpor.enums.MacinDurumu;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "Maçlar")
public class Maclar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String teamOne;

    private String teamTwo;

    private String location;

    private Date date;

    private int score1;

    private int score2;

    private MacinDurumu durum;

}
