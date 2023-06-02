package com.example.esenevlerSpor.Repositories;

import com.example.esenevlerSpor.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Admin findByMail(String mail);

}
