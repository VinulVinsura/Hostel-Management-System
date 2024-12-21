package com.example.hostelmanagementsystem.controller.student;

import com.example.hostelmanagementsystem.dto.LoginDto;
import com.example.hostelmanagementsystem.dto.ProspectiveStudentDto;
import com.example.hostelmanagementsystem.dto.ResponseDto;
import com.example.hostelmanagementsystem.service.ProspectiveStudentService;
import com.example.hostelmanagementsystem.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
@Slf4j
public class StudentController {

    private final StudentService studentService;
    private final ProspectiveStudentService prospectiveStudentService;

    @PostMapping("/save-prospective-student")
    public ResponseEntity<ResponseDto> saveProspectiveStudent(@RequestBody ProspectiveStudentDto prospectiveStudentDto){
        return ResponseEntity.ok(prospectiveStudentService.saveProspectiveStudent(prospectiveStudentDto));
    }

    @GetMapping("/get-all-prospective-student")
    public ResponseEntity<ResponseDto> getAllProspectiveStudent(){
        log.info("1");
        return ResponseEntity.ok(prospectiveStudentService.getAllProspectiveStudent());
    }


    @PostMapping("/login")
    public ResponseEntity<ResponseDto> login(@RequestBody LoginDto loginDto){
        return ResponseEntity.ok(studentService.login(loginDto));
    }

}
