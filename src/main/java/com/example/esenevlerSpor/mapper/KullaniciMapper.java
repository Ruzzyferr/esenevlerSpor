package com.example.esenevlerSpor.mapper;

import com.example.esenevlerSpor.dto.*;
import com.example.esenevlerSpor.entity.Kullanici;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public interface KullaniciMapper {

    @Named("toEntity")
    Kullanici toEntity (KullaniciDto dto);

    @Named("toDto")
    KullaniciDto toDto (Kullanici entity);

    Kullanici toEntityFromSaveRequest (KullaniciSaveRequestDTO dto);

    LoginBackDto toLoginBackDto (Kullanici entity);

}
