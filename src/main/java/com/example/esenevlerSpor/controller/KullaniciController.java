package com.example.esenevlerSpor.controller;

import com.example.esenevlerSpor.dto.KullaniciDto;
import com.example.esenevlerSpor.dto.KullaniciSaveRequestDTO;
import com.example.esenevlerSpor.dto.LoginBackDto;
import com.example.esenevlerSpor.dto.LoginDto;
import com.example.esenevlerSpor.service.KullaniciService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kullanici")
public class KullaniciController {

    private final KullaniciService kullaniciService;

    public KullaniciController(KullaniciService kullaniciService) {
        this.kullaniciService = kullaniciService;
    }

    @PostMapping("/save")
    public ResponseEntity<KullaniciDto> save(@RequestBody KullaniciSaveRequestDTO dto){
    KullaniciDto kullaniciDto = kullaniciService.save(dto);

    return new ResponseEntity<>(kullaniciDto, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginBackDto> login (@RequestBody LoginDto dto){
        LoginBackDto loginBackDto = kullaniciService.login(dto);

        if(loginBackDto.getId() == 0) loginBackDto = adminService.login(dto);

        return new ResponseEntity<>(loginBackDto, HttpStatus.OK);
    }


}
