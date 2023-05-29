package com.example.esenevlerSpor.Repositories;

import com.example.esenevlerSpor.entity.Kullanici;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KullaniciRepository extends JpaRepository<Kullanici, Integer> {

    Kullanici findByMail(String mail);


}
