package com.example.hostelmanagementsystem.controller.admin;

import com.example.hostelmanagementsystem.dto.Response.ResponseDto;
import com.example.hostelmanagementsystem.dto.RoomDto;
import com.example.hostelmanagementsystem.service.RoomManageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/room")
@RequiredArgsConstructor
public class RoomManageController {
    private final RoomManageService manageService;

    @PostMapping("/add-room")
    public ResponseEntity<ResponseDto> addRoom(@RequestBody RoomDto roomDto){
        return ResponseEntity.ok(manageService.addRoom(roomDto));
    }

    @GetMapping("/get-all-room")
    public ResponseEntity<ResponseDto> getAllRoom(){
        return ResponseEntity.ok(manageService.getAllRoom());

    }
}
