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
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    public Boolean odemeYap(@NotNull OdemeYapDto dto) {

        OdemelerOgrenciler gecici = odemelerOgrencilerRepository.
                findByOdemeler_IdAndOgrenci_Id(dto.getOdemeler().getId(), dto.getOgrenci().getId());

        gecici.setOdendiMi(true);
        Date today = Calendar. getInstance(). getTime();
        gecici.setOdenmeTarihi(today);
        odemelerOgrencilerRepository.save(gecici);
        return true;
    }


    public List<OdemelerOgrenciler> getTumOdemelerOgrenciler(GetKullaniciDto dto) {

        if (dto == null) {
            List<OdemelerOgrenciler> odemelerOgrencilers = odemelerOgrencilerRepository.findAll();
            return odemelerOgrencilers;
        }

        List<OdemelerOgrenciler> odemelerOgrencilers = odemelerOgrencilerRepository.findAllByOgrenci_Id(dto.getId());

        return odemelerOgrencilers;
    }

}
