package com.example.esenevlerSpor.service;

import com.example.esenevlerSpor.Repositories.LigRepository;
import com.example.esenevlerSpor.dto.LigDto;
import com.example.esenevlerSpor.dto.LigSaveRequestDto;
import com.example.esenevlerSpor.entity.Lig;
import com.example.esenevlerSpor.mapper.LigMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LigService {

    private final LigRepository ligRepository;
    private final LigMapper ligMapper;

    public LigService(LigRepository ligRepository, LigMapper ligMapper) {
        this.ligRepository = ligRepository;
        this.ligMapper = ligMapper;
    }

    public LigDto save(LigSaveRequestDto dto){
        Lig lig = ligMapper.toEntityFromSaveRequest(dto);

        lig = ligRepository.save(lig);

        return ligMapper.toDto(lig);
    }


    public List<LigDto> getAll() {
        List<LigDto> dtos = ligMapper.toDtoListFromEntity(ligRepository.findAll());

        return dtos;
    }
}
