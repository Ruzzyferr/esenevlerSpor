package com.example.esenevlerSpor.mapper;

import com.example.esenevlerSpor.dto.YoklamaDto;
import com.example.esenevlerSpor.entity.Yoklama;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface YoklamaMapper {

    Yoklama toEntity(YoklamaDto dto);

    YoklamaDto toDto ( Yoklama entity);

}
