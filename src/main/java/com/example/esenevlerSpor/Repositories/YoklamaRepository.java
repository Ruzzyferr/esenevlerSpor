package com.example.esenevlerSpor.Repositories;

import com.example.esenevlerSpor.entity.Kullanici;
import com.example.esenevlerSpor.entity.Sayfa;
import com.example.esenevlerSpor.entity.Yoklama;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface YoklamaRepository extends JpaRepository<Yoklama, Integer> {

    Yoklama findByOgrenci_IdAndTarih(int id,Date date);

    Boolean existsByTarih(Date date);

}
