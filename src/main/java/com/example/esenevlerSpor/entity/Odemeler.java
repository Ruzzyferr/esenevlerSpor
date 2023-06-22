package com.example.esenevlerSpor.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "Odemeler")
public class Odemeler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "odemeler", fetch = FetchType.LAZY)
    private List<OdemelerOgrenciler> odemelerOgrenciler;

    private String baslik;

    private Date odemeTarihi;

    private int tutar;

    private String sebep;

}
