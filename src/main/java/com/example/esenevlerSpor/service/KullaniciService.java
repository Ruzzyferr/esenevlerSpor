package com.example.esenevlerSpor.service;

import com.example.esenevlerSpor.Repositories.KullaniciRepository;
import com.example.esenevlerSpor.dto.*;
import com.example.esenevlerSpor.entity.Kullanici;
import com.example.esenevlerSpor.enums.Role;
import com.example.esenevlerSpor.mapper.KullaniciMapper;
import com.example.esenevlerSpor.util.Encryptor;
import com.example.esenevlerSpor.util.MailService;
import com.example.esenevlerSpor.util.PasswordGenerator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KullaniciService {

    Encryptor encryptor = com.example.esenevlerSpor.util.Encryptor.getInstance();
    private final KullaniciMapper kullaniciMapper;
    private final KullaniciRepository kullaniciRepository;

    private final MailService mailService;


    public KullaniciService(KullaniciMapper kullaniciMapper, KullaniciRepository kullaniciRepository, MailService mailService) {
        this.kullaniciMapper = kullaniciMapper;
        this.kullaniciRepository = kullaniciRepository;
        this.mailService = mailService;
    }

    public KullaniciDto save(KullaniciSaveRequestDTO dto){
        Kullanici kullanici = kullaniciMapper.toEntityFromSaveRequest(dto);

        if (kullanici.getSifre() == null){

            kullanici.setSifre(PasswordGenerator.generatePassword());

        }

        mailService.sendEmail(kullanici.getMail(),
                "Esenevler Spor Kulübü",
                "Spor Kulübüne hoş geldiniz. Mail adresiniz için atanan şifre: \n \n" +
                        kullanici.getSifre() +
                        "\n \n Şifreniz ile sisteme giriş yapabilir ve değiştirebilirsiniz."
                );

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
            return loginBackDto;
        }
        return null;
    }

    public SifreDegisti sifreDegistir(SifreDegistirIstek dto){

        Kullanici gecici = kullaniciRepository.findById(dto.getId());
        SifreDegisti degisti = new SifreDegisti();


        String decryptedPassword = encryptor.gerDecryptedPassword(gecici.getSifre());

        if(dto.getMevcutSifre().equals( decryptedPassword)){
            gecici.setSifre(encryptor.generateSecurePassword(dto.getYeniSifre()));
            kullaniciRepository.save(gecici);
            degisti.setDegistiMi(true);
            degisti.setYeniSifre(dto.getYeniSifre());
            degisti.setOnay(encryptor.gerDecryptedPassword(gecici.getSifre()));
            return degisti;
        }

        return null;
    }

    public List<KullaniciDto> listAllKullanici(){

        return kullaniciMapper.toDtoListFromEntity(kullaniciRepository.findAllByAktifMiIsTrue());

    }

    public List<KullaniciDto> listAllDeactiveKullanici(){

        return kullaniciMapper.toDtoListFromEntity(kullaniciRepository.findAllByAktifMiIsFalse());

    }

    public List<KullaniciDto> getAllVeli(){
        return kullaniciMapper.toDtoListFromEntity(kullaniciRepository.findAllByRol(Role.VELI));
    }

    public KullaniciDto getKullanici(int id) {
        return kullaniciMapper.toDto(kullaniciRepository.findById(id));
    }
}
