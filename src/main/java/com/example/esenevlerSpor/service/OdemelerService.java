package com.example.esenevlerSpor.service;

import com.example.esenevlerSpor.Repositories.KullaniciRepository;
import com.example.esenevlerSpor.Repositories.OdemelerRepository;
import com.example.esenevlerSpor.dto.OdemelerDto;
import com.example.esenevlerSpor.dto.OdemelerSaveRequestDto;
import com.example.esenevlerSpor.entity.Kullanici;
import com.example.esenevlerSpor.entity.Odemeler;
import com.example.esenevlerSpor.enums.Role;
import com.example.esenevlerSpor.mapper.OdemelerMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdemelerService {

    private  final OdemelerMapper odemelerMapper;
    private final KullaniciRepository kullaniciRepository;
    private final OdemelerRepository odemelerRepository;

    public OdemelerService(OdemelerMapper odemelerMapper, KullaniciRepository kullaniciRepository, OdemelerRepository odemelerRepository) {
        this.odemelerMapper = odemelerMapper;
        this.kullaniciRepository = kullaniciRepository;
        this.odemelerRepository = odemelerRepository;
    }

    public OdemelerDto save (OdemelerSaveRequestDto dto){
        List<Kullanici> tumOgrenciler = kullaniciRepository.findAllByRol(Role.OGRENCI);

        Odemeler odeme = odemelerMapper.toEntityFromSaveRequestDto(dto);

        odeme.setOgrenci(tumOgrenciler);

        odeme = odemelerRepository.save(odeme);

        return odemelerMapper.toDto(odeme);
    }


}
