package com.example.hostelmanagementsystem.service;

import com.example.hostelmanagementsystem.dto.DamageCaseDto;
import com.example.hostelmanagementsystem.dto.DamageMasterDto;
import com.example.hostelmanagementsystem.dto.Response.ResponseDto;

public interface DamageService {
    ResponseDto addDamageMaster(DamageMasterDto damageMasterDto);

    ResponseDto addDamageCase(DamageCaseDto damageCaseDto);

    ResponseDto getAllDamageMaster();

    ResponseDto getAllDamageCase();
}
