package com.example.esenevlerSpor.controller;

import com.example.esenevlerSpor.dto.YoklamaAlDto;
import com.example.esenevlerSpor.service.YoklamaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
