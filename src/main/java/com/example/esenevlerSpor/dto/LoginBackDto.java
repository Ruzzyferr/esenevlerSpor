package com.example.esenevlerSpor.dto;

import com.example.esenevlerSpor.enums.Roles;
import lombok.Data;

@Data
public class LoginBackDto {

    private int id;

    private Roles roles;

}
