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

        if(kullaniciRepository.existsById(dto.getId())){
            Kullanici kullanici1 = kullaniciRepository.findById(dto.getId());

            kullanici.setSifre(encryptor.gerDecryptedPassword(kullanici1.getSifre()));
            kullanici.setSifre(encryptor.generateSecurePassword(kullanici.getSifre()));

            kullanici = kullaniciRepository.save(kullanici);
            KullaniciDto getDto = kullaniciMapper.toDto(kullanici);

            getDto.setSifre(encryptor.gerDecryptedPassword(getDto.getSifre()));

            return getDto;
        }


        if(kullaniciRepository.existsByMail(dto.getMail()) ){
            return new KullaniciDto();
        }


        if (kullanici.getSifre() == null){

            kullanici.setSifre(PasswordGenerator.generatePassword());

        }

        if(dto.getId() == 0) {
            mailService.sendEmail(kullanici.getMail(),
                    "Esenevler Spor Kulübü",
                    "Spor Kulübüne hoş geldiniz. Mail adresiniz için atanan şifre: \n \n" +
                            kullanici.getSifre() +
                            "\n \n Şifreniz ile sisteme giriş yapabilir ve değiştirebilirsiniz."
            );
        }

        //encrypted
        kullanici.setSifre(encryptor.generateSecurePassword(kullanici.getSifre()));

        kullanici = kullaniciRepository.save(kullanici);

        KullaniciDto getDto = kullaniciMapper.toDto(kullanici);

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

    public Boolean sifremiUnuttum(SifreDegistirIstek dto) {

        Kullanici kullanici = kullaniciRepository.findById(dto.getId());

        String string = PasswordGenerator.generatePassword();

        kullanici.setSifre(encryptor.generateSecurePassword(string));
        kullaniciRepository.save(kullanici);

        mailService.sendEmail(kullanici.getMail(),
                "Esenevler Spor Kulübü",
                "Spor Kulübüne hoş geldiniz. Mail adresiniz için atanan şifre: \n \n" +
                        string +
                        "\n \n Şifreniz ile sisteme giriş yapabilir ve değiştirebilirsiniz.");

        return true;
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

    public List<KullaniciDto> getAllOgrenci(){
        return kullaniciMapper.toDtoListFromEntity(kullaniciRepository.findAllByRolAndAktifMiIsTrue(Role.OGRENCI));
    }

    public KullaniciDto getKullanici(IdDto dto) {
        return kullaniciMapper.toDto(kullaniciRepository.findById(dto.getId()));
    }


    public List<KullaniciDto> cocuklarim(IdDto dto) {

        return kullaniciMapper.toDtoListFromEntity(kullaniciRepository.findAllByVeli_Id(dto.getId()));

    }
}
