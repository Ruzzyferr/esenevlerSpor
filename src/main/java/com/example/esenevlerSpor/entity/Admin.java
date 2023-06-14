package com.example.esenevlerSpor.entity;

import com.example.esenevlerSpor.enums.Role;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String isim;

    private String soyadı;

    private String mail;

    private String sifre;

    private Role rol;

}
