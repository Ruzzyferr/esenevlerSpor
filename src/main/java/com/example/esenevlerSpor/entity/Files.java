package com.example.esenevlerSpor.entity;

import com.example.esenevlerSpor.enums.DosyaKategori;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Dosyalar")
public class Files {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private OgrenciDetay ogrenciId;

    private String name;

    private DosyaKategori dosyaKategori;


}
