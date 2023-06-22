package com.example.esenevlerSpor.service;

import com.example.esenevlerSpor.Repositories.KullaniciRepository;
import com.example.esenevlerSpor.Repositories.OdemelerOgrencilerRepository;
import com.example.esenevlerSpor.Repositories.OdemelerRepository;
import com.example.esenevlerSpor.dto.*;
import com.example.esenevlerSpor.entity.Kullanici;
import com.example.esenevlerSpor.entity.Odemeler;
import com.example.esenevlerSpor.entity.OdemelerOgrenciler;
import com.example.esenevlerSpor.enums.Role;
import com.example.esenevlerSpor.mapper.OdemelerMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OdemelerService {

    private final OdemelerMapper odemelerMapper;
    private final KullaniciRepository kullaniciRepository;
    private final OdemelerRepository odemelerRepository;
    private final OdemelerOgrencilerRepository odemelerOgrencilerRepository;

    public OdemelerService(OdemelerMapper odemelerMapper, KullaniciRepository kullaniciRepository, OdemelerRepository odemelerRepository, OdemelerOgrencilerRepository odemelerOgrencilerRepository) {
        this.odemelerMapper = odemelerMapper;
        this.kullaniciRepository = kullaniciRepository;
        this.odemelerRepository = odemelerRepository;
        this.odemelerOgrencilerRepository = odemelerOgrencilerRepository;
    }

    public OdemelerDto save(OdemelerSaveRequestDto dto) {
        List<Kullanici> tumOgrenciler = kullaniciRepository.findAllByRol(Role.OGRENCI);


        Odemeler odeme = odemelerMapper.toEntityFromSaveRequestDto(dto);
        odeme = odemelerRepository.save(odeme);

        for (Kullanici ogrenci : tumOgrenciler) {
            OdemelerOgrenciler odemelerOgrenciler = new OdemelerOgrenciler();
            odemelerOgrenciler.setOdemeler(odeme);
            odemelerOgrenciler.setOgrenci(ogrenci);
            odemelerOgrenciler.setOdendiMi(false);

            odemelerOgrencilerRepository.save(odemelerOgrenciler);
        }

        return odemelerMapper.toDto(odeme);
    }

    public Boolean odemeYap(OdemeYapDto dto) {

        OdemelerOgrenciler gecici = odemelerOgrencilerRepository.
                findByOdemelerAndOgrenci(dto.getOdemeler(), dto.getOgrenci());

        gecici.setOdendiMi(true);
        odemelerOgrencilerRepository.save(gecici);
        return true;
    }

/*
    public GetTumOdemeBilgileriDto getTumOdemelerOgrenciler() {
        GetTumOdemeBilgileriDto getTumOdemeBilgileriDto = new GetTumOdemeBilgileriDto();
        getTumOdemeBilgileriDto.setOdemelerOgrencilers(odemelerOgrencilerRepository.findAll());
        return getTumOdemeBilgileriDto;
    }

 */
}
