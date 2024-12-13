package com.example.hostelmanagementsystem.controller;

import com.example.hostelmanagementsystem.dto.HostelDetailDto;
import com.example.hostelmanagementsystem.dto.ResponseDto;
import com.example.hostelmanagementsystem.service.HostelManageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hostel")
@RequiredArgsConstructor
public class HostelManagementController {
    private final HostelManageService hostelService;

    @PostMapping("/add-hostel")
    public ResponseEntity<ResponseDto> addHostel(@RequestBody HostelDetailDto hostelDetailDto){
        return ResponseEntity.ok(hostelService.addHostel(hostelDetailDto));
    }
}
