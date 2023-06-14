package com.example.esenevlerSpor.mapper;

import com.example.esenevlerSpor.dto.SayfaDto;
import com.example.esenevlerSpor.dto.SayfaSaveRequestDto;
import com.example.esenevlerSpor.entity.Sayfa;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SayfaMapper {

    Sayfa toEntity (SayfaDto dto);

    Sayfa toEntityFromSaveRequestDto (SayfaSaveRequestDto dto);

    SayfaDto toDto (Sayfa entity);

    List<SayfaDto> toDtoListFromEntity (List<Sayfa> entity);

}
