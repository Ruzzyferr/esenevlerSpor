package com.example.esenevlerSpor.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String Surname;

    private String mail;

    private String password;


}
