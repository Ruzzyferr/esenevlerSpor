package com.example.esenevlerSpor.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "Lig")
public class Lig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String ligAdi;

    private String yasGrubu;

    private Date kurulmaTarihi;



}
