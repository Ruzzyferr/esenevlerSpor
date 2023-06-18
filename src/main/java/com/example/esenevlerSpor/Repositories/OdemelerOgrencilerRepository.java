package com.example.esenevlerSpor.Repositories;

import com.example.esenevlerSpor.entity.Kullanici;
import com.example.esenevlerSpor.entity.Odemeler;
import com.example.esenevlerSpor.entity.OdemelerOgrenciler;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OdemelerOgrencilerRepository extends JpaRepository<OdemelerOgrenciler, Integer> {
    OdemelerOgrenciler findByOdemelerAndOgrenci(Odemeler odemeler, Kullanici ogrenci);

}
