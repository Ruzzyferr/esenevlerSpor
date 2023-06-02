package com.example.esenevlerSpor.mapper;

import com.example.esenevlerSpor.dto.AdminDto;
import com.example.esenevlerSpor.dto.AdminSaveRequestDto;
import com.example.esenevlerSpor.dto.KullaniciSaveRequestDTO;
import com.example.esenevlerSpor.dto.LoginBackDto;
import com.example.esenevlerSpor.entity.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface AdminMapper {

    @Named("toEntity")
    Admin toEntity (AdminDto dto);

    @Named("toDto")
    AdminDto toDto (Admin entity);

    Admin toEntityFromSaveRequestDto (AdminSaveRequestDto dto);

    LoginBackDto toLoginBackDto (Admin entity);

}
