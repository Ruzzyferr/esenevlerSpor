package com.example.esenevlerSpor.controller;

import com.example.esenevlerSpor.Repositories.LigRepository;
import com.example.esenevlerSpor.dto.LigDto;
import com.example.esenevlerSpor.dto.LigSaveRequestDto;
import com.example.esenevlerSpor.dto.SayfaDto;
import com.example.esenevlerSpor.dto.SayfaSaveRequestDto;
import com.example.esenevlerSpor.service.LigService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lig")
public class LigController {

    private final LigService ligService;
    private final LigRepository ligRepository;

    public LigController(LigService ligService, LigRepository ligRepository) {
        this.ligService = ligService;
        this.ligRepository = ligRepository;
    }

    @PostMapping("/save")
    public ResponseEntity<LigDto> save(@RequestBody LigSaveRequestDto dto){

        return new ResponseEntity<>(ligService.save(dto), HttpStatus.OK);
    }

    @GetMapping("/getalllig")
    public ResponseEntity<List<LigDto>> getAll(){
        return new ResponseEntity<>(ligService.getAll(), HttpStatus.OK);
    }
}
