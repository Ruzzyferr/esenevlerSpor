package com.example.esenevlerSpor.dto;

import com.example.esenevlerSpor.entity.Files;
import com.example.esenevlerSpor.entity.Kullanici;
import com.example.esenevlerSpor.entity.Takim;
import lombok.Data;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Data
public class OgrenciDetayDto {

    private int id;

    private String anneAdi;

    private String anneTlf;

    private String anneMeslek;

    private String babaAdi;

    private String babaTlf;

    private String babaMeslek;

    private String uniformNumber;

    private String position;

    private Takim takim;

    private String league;

    private Kullanici veli;

    private List<Files> files;

}
