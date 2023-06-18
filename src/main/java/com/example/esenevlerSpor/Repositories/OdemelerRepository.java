package com.example.esenevlerSpor.Repositories;

import com.example.esenevlerSpor.entity.Kullanici;
import com.example.esenevlerSpor.entity.Odemeler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdemelerRepository extends JpaRepository<Odemeler, Integer> {

    Odemeler getAllBy();

    Odemeler findById(int id);

}
