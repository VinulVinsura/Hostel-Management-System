package com.example.hostelmanagementsystem.controller.admin;

import com.example.hostelmanagementsystem.dto.HostelDetailDto;
import com.example.hostelmanagementsystem.dto.Response.ResponseDto;
import com.example.hostelmanagementsystem.service.HostelManageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hostel")
@RequiredArgsConstructor
public class HostelManagementController {
    private final HostelManageService hostelService;

    @PostMapping("/add-hostel")
    public ResponseEntity<ResponseDto> addHostel(@RequestBody HostelDetailDto hostelDetailDto){
        return ResponseEntity.ok(hostelService.addHostel(hostelDetailDto));
    }
    @GetMapping("/get-all-hostal")
    public ResponseEntity<ResponseDto> getAllHostel(){
        return ResponseEntity.ok(hostelService.getAllHostel());
    }
}
