package com.example.esenevlerSpor.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class LigWithCountDto {

    private List<LigDto> dtos = new ArrayList<>();

    private int count;

}
