package com.example.esenevlerSpor.controller;

import com.example.esenevlerSpor.dto.KullaniciDto;
import com.example.esenevlerSpor.dto.KullaniciSaveRequestDTO;
import com.example.esenevlerSpor.dto.LoginBackDto;
import com.example.esenevlerSpor.dto.LoginDto;
import com.example.esenevlerSpor.service.AdminService;
import com.example.esenevlerSpor.service.KullaniciService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kullanici")
public class KullaniciController {

    private final KullaniciService kullaniciService;
    private final AdminService adminService;

    public KullaniciController(KullaniciService kullaniciService, AdminService adminService) {
        this.kullaniciService = kullaniciService;
        this.adminService = adminService;
    }

    @PostMapping("/save")
    public ResponseEntity<KullaniciDto> save(@RequestBody KullaniciSaveRequestDTO dto){
        //admin kontrolü
    KullaniciDto kullaniciDto = kullaniciService.save(dto);

    return new ResponseEntity<>(kullaniciDto, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginBackDto> login (@RequestBody LoginDto dto){
        LoginBackDto loginBackDto = kullaniciService.login(dto);

        if(loginBackDto.getId() == 0) loginBackDto = adminService.login(dto);

        return new ResponseEntity<>(loginBackDto, HttpStatus.OK);
    }

    @GetMapping("/activeusers")
    public ResponseEntity<List<KullaniciDto>> getAllKullanici(){

        return new ResponseEntity<>(kullaniciService.listAllKullanici(), HttpStatus.OK);
    }

    @GetMapping("/deactiveusers")
    public ResponseEntity<List<KullaniciDto>> getAllDeactiveKullanici(){

        return new ResponseEntity<>(kullaniciService.listAllDeactiveKullanici(), HttpStatus.OK);
    }


}
