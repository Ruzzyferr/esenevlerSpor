package com.example.esenevlerSpor.Repositories;

import com.example.esenevlerSpor.entity.Kullanici;
import com.example.esenevlerSpor.entity.Sayfa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SayfaRepository extends JpaRepository<Sayfa, Integer> {

    List<Sayfa> findAllByAktifIsTrue();

}
