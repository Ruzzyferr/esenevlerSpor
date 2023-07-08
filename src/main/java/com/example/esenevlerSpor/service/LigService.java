package com.example.esenevlerSpor.service;

import com.example.esenevlerSpor.Repositories.KullaniciRepository;
import com.example.esenevlerSpor.Repositories.LigRepository;
import com.example.esenevlerSpor.dto.LigDto;
import com.example.esenevlerSpor.dto.LigSaveRequestDto;
import com.example.esenevlerSpor.dto.LigWithCountDto;
import com.example.esenevlerSpor.entity.Kullanici;
import com.example.esenevlerSpor.entity.Lig;
import com.example.esenevlerSpor.mapper.LigMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LigService {

    private final LigRepository ligRepository;
    private final LigMapper ligMapper;
    private final KullaniciRepository kullaniciRepository;

    public LigService(LigRepository ligRepository, LigMapper ligMapper, KullaniciRepository kullaniciRepository) {
        this.ligRepository = ligRepository;
        this.ligMapper = ligMapper;
        this.kullaniciRepository = kullaniciRepository;
    }

    public LigDto save(LigSaveRequestDto dto){
        Lig lig = ligMapper.toEntityFromSaveRequest(dto);

        lig = ligRepository.save(lig);

        return ligMapper.toDto(lig);
    }


    public LigWithCountDto getAll() {
        List<LigDto> dtos = ligMapper.toDtoListFromEntity(ligRepository.findAll());

        for(LigDto dto : dtos){
            List<Kullanici> gecici = new ArrayList<>();

            gecici = kullaniciRepository.findAllByLig(ligMapper.toEntity(dto));

            dto.setOyuncuCount(gecici.size());
        }

        LigWithCountDto dto = new LigWithCountDto();

        dto.setDtos(dtos);
        dto.setCount(dtos.size());

        return dto;
    }
}
