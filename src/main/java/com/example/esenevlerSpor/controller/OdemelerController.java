package com.example.esenevlerSpor.controller;

import com.example.esenevlerSpor.dto.*;
import com.example.esenevlerSpor.entity.OdemelerOgrenciler;
import com.example.esenevlerSpor.service.OdemelerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/odemeler")
public class OdemelerController {

    private final OdemelerService odemelerService;

    public OdemelerController(OdemelerService odemelerService) {
        this.odemelerService = odemelerService;
    }

    @PostMapping("/save")
    public ResponseEntity<OdemelerDto> save(@RequestBody OdemelerSaveRequestDto dto){
        //admin kontrolü
        OdemelerDto odemelerDto = odemelerService.save(dto);

        return new ResponseEntity<>(odemelerDto, HttpStatus.OK);
    }

    @PostMapping("/odemeyap")
    public ResponseEntity<Boolean> odemeYap (@RequestBody OdemeYapDto dto){


       return new ResponseEntity<>(odemelerService.odemeYap(dto) ,HttpStatus.OK);
    }

    /*
    @GetMapping("/gettumodemebilgileri")
    public ResponseEntity<GetTumOdemeBilgileriDto> getTumOdemeBilgileri (){
        return new ResponseEntity<>(odemelerService.getTumOdemelerOgrenciler(), HttpStatus.OK);
    }

     */

}
