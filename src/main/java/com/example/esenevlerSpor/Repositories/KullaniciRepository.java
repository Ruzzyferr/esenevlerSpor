package com.example.esenevlerSpor.Repositories;

import com.example.esenevlerSpor.dto.KullaniciDto;
import com.example.esenevlerSpor.entity.Kullanici;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KullaniciRepository extends JpaRepository<Kullanici, Integer> {

    Kullanici findByMail(String mail);

    List<Kullanici> findAllByAktifMiIsTrue();

    List<Kullanici> findAllByAktifMiIsFalse();

    Kullanici findById(int id);

    List<Kullanici> findAllByRolVeli();


}
