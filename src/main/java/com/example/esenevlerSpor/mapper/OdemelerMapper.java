package com.example.esenevlerSpor.mapper;

import com.example.esenevlerSpor.dto.OdemelerDto;
import com.example.esenevlerSpor.dto.OdemelerSaveRequestDto;
import com.example.esenevlerSpor.entity.Odemeler;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OdemelerMapper {

    Odemeler toEntityFromSaveRequestDto(OdemelerSaveRequestDto dto);

    OdemelerDto toDto (Odemeler entity);

    Odemeler toEntity (OdemelerDto dto);

}
