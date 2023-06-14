package com.example.esenevlerSpor.service;

import com.example.esenevlerSpor.Repositories.KullaniciRepository;
import com.example.esenevlerSpor.dto.KullaniciDto;
import com.example.esenevlerSpor.dto.KullaniciSaveRequestDTO;
import com.example.esenevlerSpor.dto.LoginBackDto;
import com.example.esenevlerSpor.dto.LoginDto;
import com.example.esenevlerSpor.entity.Kullanici;
import com.example.esenevlerSpor.mapper.KullaniciMapper;
import com.example.esenevlerSpor.util.Encryptor;
import com.example.esenevlerSpor.util.PasswordGenerator;
import org.springframework.stereotype.Service;

import java.util.List;

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

        if (kullanici.getSifre() == null){

            kullanici.setSifre(PasswordGenerator.generatePassword());

        }

        //encrypted
        kullanici.setSifre(encryptor.generateSecurePassword(kullanici.getSifre()));
        kullanici.setTcNo(encryptor.generateSecurePassword(kullanici.getTcNo()));

        kullanici = kullaniciRepository.save(kullanici);

        KullaniciDto getDto = kullaniciMapper.toDto(kullanici);

        getDto.setTcNo(encryptor.gerDecryptedPassword(getDto.getTcNo()));
        getDto.setSifre(encryptor.gerDecryptedPassword(getDto.getSifre()));

        return getDto;
    }

    public LoginBackDto login (LoginDto dto){

        LoginBackDto loginBackDto = new LoginBackDto();

        Kullanici gecici = kullaniciRepository.findByMail(dto.getMail());

        String decryptedPassword = encryptor.gerDecryptedPassword(gecici.getSifre());

        if(dto.getSifre().equals(decryptedPassword) ) {

            loginBackDto.setId(gecici.getId());
            loginBackDto.setRole(gecici.getRol());

        }
        return loginBackDto;
    }

    public List<KullaniciDto> listAllKullanici(){

        return kullaniciMapper.toDtoListFromEntity(kullaniciRepository.findAllByAktifMiIsTrue());

    }

    public List<KullaniciDto> listAllDeactiveKullanici(){

        return kullaniciMapper.toDtoListFromEntity(kullaniciRepository.findAllByAktifMiIsFalse());

    }

}
