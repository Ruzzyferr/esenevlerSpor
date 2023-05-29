package com.example.esenevlerSpor.service;

import com.example.esenevlerSpor.Repositories.KullaniciRepository;
import com.example.esenevlerSpor.dto.KullaniciDto;
import com.example.esenevlerSpor.dto.KullaniciSaveRequestDTO;
import com.example.esenevlerSpor.dto.LoginBackDto;
import com.example.esenevlerSpor.dto.LoginDto;
import com.example.esenevlerSpor.entity.Kullanici;
import com.example.esenevlerSpor.enums.Roles;
import com.example.esenevlerSpor.mapper.KullaniciMapper;
import com.example.esenevlerSpor.util.Encryptor;
import com.example.esenevlerSpor.util.PasswordGenerator;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class KullaniciService {

    Encryptor encryptor = com.example.esenevlerSpor.util.Encryptor.getInstance();
    private final KullaniciMapper kullaniciMapper;
    private final KullaniciRepository kullaniciRepository;


    public KullaniciService(KullaniciMapper kullaniciMapper, KullaniciRepository kullaniciRepository) {
        this.kullaniciMapper = kullaniciMapper;
        this.kullaniciRepository = kullaniciRepository;
    }

    public KullaniciDto save(KullaniciSaveRequestDTO dto){
        Kullanici kullanici = kullaniciMapper.toEntityFromSaveRequest(dto);

        if (kullanici.getPassword() == null){
            kullanici.setPassword(PasswordGenerator.generatePassword());
        }

        //encrypted
        kullanici.setPassword(encryptor.generateSecurePassword(kullanici.getPassword()));
        kullanici.setTcNo(encryptor.generateSecurePassword(kullanici.getTcNo()));

        kullanici = kullaniciRepository.save(kullanici);

        KullaniciDto getDto = kullaniciMapper.toDto(kullanici);

        getDto.setTcNo(encryptor.gerDecryptedPassword(getDto.getTcNo()));
        getDto.setPassword(encryptor.gerDecryptedPassword(getDto.getPassword()));

        return getDto;
    }

    public LoginBackDto login (LoginDto dto){

        LoginBackDto loginBackDto = new LoginBackDto();

        Kullanici gecici = kullaniciRepository.findByMail(dto.getMail());

        String isTure = encryptor.gerDecryptedPassword(gecici.getPassword());

        if(dto.getPassword().equals(isTure) ) {

            loginBackDto.setId(gecici.getId());
            loginBackDto.setRoles(gecici.getRole());

        }
        return loginBackDto;
    }

}
