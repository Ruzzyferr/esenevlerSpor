package com.example.esenevlerSpor.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Odemeler")
public class Odemeler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private OgrenciDetay ogrenciId;

    private int donem;

    private int totalPrice;

    private boolean isPaid;

}
