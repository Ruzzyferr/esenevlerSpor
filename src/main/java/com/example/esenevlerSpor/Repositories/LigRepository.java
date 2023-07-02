package com.example.esenevlerSpor.Repositories;

import com.example.esenevlerSpor.entity.Lig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigRepository extends JpaRepository<Lig, Integer> {
}
