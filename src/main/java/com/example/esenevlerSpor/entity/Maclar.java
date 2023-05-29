package com.example.esenevlerSpor.entity;


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

    private int Score;

    private boolean didWin;

    private boolean isPlayed;

}
