package com.example.esenevlerSpor.controller;

import com.example.esenevlerSpor.dto.GetDateDto;
import com.example.esenevlerSpor.dto.IdDto;
import com.example.esenevlerSpor.dto.YoklamaAlDto;
import com.example.esenevlerSpor.entity.Yoklama;
import com.example.esenevlerSpor.service.YoklamaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/yoklama")
public class YoklamaController {

    private final YoklamaService yoklamaService;

    public YoklamaController(YoklamaService yoklamaService) {
        this.yoklamaService = yoklamaService;
    }


    @PostMapping("/yoklamaal")
    public ResponseEntity<Boolean> yoklamaAl (@RequestBody YoklamaAlDto dto){
        return new ResponseEntity<>(yoklamaService.yoklamaAL(dto), HttpStatus.OK);
    }

    @GetMapping("/gettumyoklamabilgileri")
    public ResponseEntity<List<Yoklama>> getTumYoklamaBilgileri (@RequestBody(required = false) IdDto dto){
        return new ResponseEntity<>(yoklamaService.getTumYoklamaOgrenciler(dto), HttpStatus.OK);
    }

    @GetMapping("/gettumyoklamabilgileridate")
    public ResponseEntity<List<Yoklama>> getTumYoklamaBilgileriDate (@RequestBody GetDateDto dto){
        return new ResponseEntity<>(yoklamaService.getTumYoklamaOgrencilerDate(dto), HttpStatus.OK);
    }


}
