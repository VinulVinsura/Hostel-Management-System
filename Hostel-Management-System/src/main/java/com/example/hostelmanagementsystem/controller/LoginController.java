package com.example.hostelmanagementsystem.controller;

import com.example.hostelmanagementsystem.dto.LoginDto;
import com.example.hostelmanagementsystem.dto.Response.ResponseDto;
import com.example.hostelmanagementsystem.service.ProspectiveStudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/main")
@RequiredArgsConstructor
@Slf4j
public class LoginController {
    private final ProspectiveStudentService prospectiveStudentService;

    @PostMapping("/login")
    public ResponseEntity<ResponseDto> login(@RequestBody LoginDto loginDto){
        log.info(loginDto.getEmail());
        return ResponseEntity.ok(prospectiveStudentService.login(loginDto));
    }

}
