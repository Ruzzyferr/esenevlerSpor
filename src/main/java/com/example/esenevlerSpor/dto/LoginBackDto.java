package com.example.esenevlerSpor.dto;

import com.example.esenevlerSpor.enums.Role;
import lombok.Data;

@Data
public class LoginBackDto {

    private int id;

    private Role role;

}
