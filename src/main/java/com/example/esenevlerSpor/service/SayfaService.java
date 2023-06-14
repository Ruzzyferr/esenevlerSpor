package com.example.esenevlerSpor.service;

import com.example.esenevlerSpor.Repositories.SayfaRepository;
import com.example.esenevlerSpor.dto.SayfaDto;
import com.example.esenevlerSpor.dto.SayfaSaveRequestDto;
import com.example.esenevlerSpor.entity.Sayfa;
import com.example.esenevlerSpor.mapper.SayfaMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SayfaService {

    private final SayfaMapper sayfaMapper;
    private final SayfaRepository sayfaRepository;


    public SayfaService(SayfaMapper sayfaMapper, SayfaRepository sayfaRepository) {
        this.sayfaMapper = sayfaMapper;
        this.sayfaRepository = sayfaRepository;
    }

    public SayfaDto save(SayfaSaveRequestDto dto){

        Sayfa sayfa = sayfaMapper.toEntityFromSaveRequestDto(dto);

        sayfa = sayfaRepository.save(sayfa);

        return sayfaMapper.toDto(sayfa);
    }


    public List<SayfaDto> listAllSayfa(){

        return sayfaMapper.toDtoListFromEntity(sayfaRepository.findAllByAktifIsTrue());

    }

}
