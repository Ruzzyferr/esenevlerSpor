package com.example.esenevlerSpor.controller;

import com.example.esenevlerSpor.dto.KullaniciDto;
import com.example.esenevlerSpor.dto.SayfaDto;
import com.example.esenevlerSpor.dto.SayfaSaveRequestDto;
import com.example.esenevlerSpor.service.SayfaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sayfa")
public class SayfaController {

    private final SayfaService service;

    public SayfaController(SayfaService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<SayfaDto> save(@RequestBody SayfaSaveRequestDto dto){
        //admin kontrolü
        SayfaDto sayfaDto = service.save(dto);

        return new ResponseEntity<>(sayfaDto, HttpStatus.OK);
    }

    @GetMapping("/getallsayfa")
    public ResponseEntity<List<SayfaDto>> getAllKullanici(){

        return new ResponseEntity<>(service.listAllSayfa(), HttpStatus.OK);

    }


}
