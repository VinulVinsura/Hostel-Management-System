package com.example.hostelmanagementsystem.controller.admin;

import com.example.hostelmanagementsystem.dto.Response.ResponseDto;
import com.example.hostelmanagementsystem.dto.UserDto;
import com.example.hostelmanagementsystem.service.UserManageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@Slf4j
@CrossOrigin("*")
public class UserManagementController {

    @Autowired
    private  UserManageService userManageService;

    @PostMapping("/save-user")
    public ResponseEntity<ResponseDto> saveUser(@RequestBody UserDto userDto){
        try {
            return ResponseEntity.ok(userManageService.saveUser(userDto));
        }catch (UnexpectedRollbackException ex){
            log.error("Error");
            return ResponseEntity.ok(new ResponseDto(02,ex.getMessage()));
        }
    }

    // (/api/user/get-all-eligible-student)
    @GetMapping("/get-all-eligible-student")
    public ResponseEntity<ResponseDto> getEligibleStudents(){
        return ResponseEntity.ok(userManageService.getEligibleStudents());
    }
}
