package com.example.hostelmanagementsystem.controller.admin;

import com.example.hostelmanagementsystem.dto.DamageCaseDto;
import com.example.hostelmanagementsystem.dto.DamageMasterDto;
import com.example.hostelmanagementsystem.dto.Response.ResponseDto;
import com.example.hostelmanagementsystem.service.DamageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/damage")
@RequiredArgsConstructor
@Slf4j
public class DamageController {

    private final DamageService damageService;

    @PostMapping("/add-damage-master")
    public ResponseEntity<ResponseDto> addDamageMaster(@RequestBody DamageMasterDto damageMasterDto){
        log.info(damageMasterDto.getDescription());
        return ResponseEntity.ok(damageService.addDamageMaster(damageMasterDto));
    }

    @PostMapping("/add-damage-case")
    public ResponseEntity<ResponseDto> addDamageCase(@RequestBody DamageCaseDto damageCaseDto){
        return ResponseEntity.ok(damageService.addDamageCase(damageCaseDto));
    }

}
