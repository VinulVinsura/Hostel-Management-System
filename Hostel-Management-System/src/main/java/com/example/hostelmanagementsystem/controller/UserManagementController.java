package com.example.hostelmanagementsystem.controller;

import com.example.hostelmanagementsystem.dto.UserDto;
import com.example.hostelmanagementsystem.service.UserManageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@Slf4j
@CrossOrigin("*")
public class UserManagementController {

    @Autowired
    private  UserManageService userManageService;

    @PostMapping("/save-user")
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto){
        log.info("1");
        System.out.println("1");
        return ResponseEntity.ok(userManageService.saveUser(userDto));

    }
}
