package com.example.esenevlerSpor.service;

import com.example.esenevlerSpor.Repositories.AdminRepository;
import com.example.esenevlerSpor.dto.AdminDto;
import com.example.esenevlerSpor.dto.AdminSaveRequestDto;
import com.example.esenevlerSpor.dto.LoginBackDto;
import com.example.esenevlerSpor.dto.LoginDto;
import com.example.esenevlerSpor.entity.Admin;
import com.example.esenevlerSpor.mapper.AdminMapper;
import com.example.esenevlerSpor.util.Encryptor;
import com.example.esenevlerSpor.util.PasswordGenerator;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    Encryptor encryptor = com.example.esenevlerSpor.util.Encryptor.getInstance();

    private final AdminRepository adminRepository;

    private final AdminMapper adminMapper;

    public AdminService(AdminRepository adminRepository, AdminMapper adminMapper) {
        this.adminRepository = adminRepository;
        this.adminMapper = adminMapper;
    }

    public AdminDto save(AdminSaveRequestDto dto) {
        Admin admin = adminMapper.toEntityFromSaveRequestDto(dto);

        if (admin.getSifre() == null) {

            admin.setSifre(PasswordGenerator.generatePassword());

        }
        admin.setSifre(encryptor.generateSecurePassword(admin.getSifre()));

         admin = adminRepository.save(admin);

        AdminDto getDto = adminMapper.toDto(admin);

        getDto.setSifre(encryptor.gerDecryptedPassword(getDto.getSifre()));

        return getDto;
    }

    public LoginBackDto login (LoginDto dto){

        LoginBackDto loginBackDto = new LoginBackDto();

        Admin gecici = adminRepository.findByMail(dto.getMail());

        String isTure = encryptor.gerDecryptedPassword(gecici.getSifre());

        if(dto.getSifre().equals(isTure) ) {

            loginBackDto.setId(gecici.getId());

        }
        return loginBackDto;
    }

}
