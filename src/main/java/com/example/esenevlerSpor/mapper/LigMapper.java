package com.example.esenevlerSpor.mapper;

import com.example.esenevlerSpor.dto.KullaniciDto;
import com.example.esenevlerSpor.dto.KullaniciSaveRequestDTO;
import com.example.esenevlerSpor.dto.LigDto;
import com.example.esenevlerSpor.dto.LigSaveRequestDto;
import com.example.esenevlerSpor.entity.Kullanici;
import com.example.esenevlerSpor.entity.Lig;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LigMapper {

    @Named("toEntity")
    Lig toEntity (LigDto dto);

    @Named("toDto")
    LigDto toDto (Lig entity);

    List<LigDto> toDtoListFromEntity (List<Lig> entity);

    Lig toEntityFromSaveRequest (LigSaveRequestDto dto);

}
