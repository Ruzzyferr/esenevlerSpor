package com.example.esenevlerSpor.service;

import com.example.esenevlerSpor.Repositories.KullaniciRepository;
import com.example.esenevlerSpor.Repositories.YoklamaRepository;
import com.example.esenevlerSpor.dto.GetDateDto;
import com.example.esenevlerSpor.dto.GetKullaniciDto;
import com.example.esenevlerSpor.dto.YoklamaAlDto;
import com.example.esenevlerSpor.dto.YoklamaDto;
import com.example.esenevlerSpor.entity.Kullanici;
import com.example.esenevlerSpor.entity.OdemelerOgrenciler;
import com.example.esenevlerSpor.entity.Yoklama;
import com.example.esenevlerSpor.enums.Role;
import com.example.esenevlerSpor.mapper.YoklamaMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YoklamaService {

private final KullaniciRepository kullaniciRepository;
private final YoklamaRepository yoklamaRepository;
private final YoklamaMapper yoklamaMapper;

    public YoklamaService(KullaniciRepository kullaniciRepository, YoklamaRepository yoklamaRepository, YoklamaMapper yoklamaMapper) {
        this.kullaniciRepository = kullaniciRepository;
        this.yoklamaRepository = yoklamaRepository;
        this.yoklamaMapper = yoklamaMapper;
    }

    public Boolean yoklamaAL(YoklamaAlDto dto) {

        List<Kullanici> ogrenciler = kullaniciRepository.findAllByRol(Role.OGRENCI);
        List<Kullanici> gelenOgrenciler = dto.getKullanicis();

        Boolean varMi = yoklamaRepository.existsByTarih(dto.getDate());

        if(varMi.equals(false)) {
            for (Kullanici ogrenci : ogrenciler) {

                YoklamaDto dto1 = new YoklamaDto();
                dto1.setOgrenci(ogrenci);
                dto1.setTarih(dto.getDate());

                yoklamaRepository.save(yoklamaMapper.toEntity(dto1));
            }
        }

        for (Kullanici ogrenci : gelenOgrenciler){

            Yoklama yoklama = yoklamaRepository.findByOgrenci_IdAndTarih(ogrenci.getId(), dto.getDate());
            yoklama.setGeldiMi(true);
            yoklamaRepository.save(yoklama);

        }

        return true;
    }

    public List<Yoklama> getTumYoklamaOgrenciler(GetKullaniciDto dto) {

        if (dto == null) {
            List<Yoklama> yoklamas = yoklamaRepository.findAll();
            return yoklamas;
        }

        List<Yoklama> yoklamas = yoklamaRepository.findAllByOgrenci_Id(dto.getId());

        return yoklamas;
    }

    public List<Yoklama> getTumYoklamaOgrencilerDate(GetDateDto dto) {

        List<Yoklama> yoklamas = yoklamaRepository.findAllByTarih(dto.getDate());

        return yoklamas;

    }
}
