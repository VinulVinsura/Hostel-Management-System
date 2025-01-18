package com.example.hostelmanagementsystem.controller.student;

import com.example.hostelmanagementsystem.dto.LoginDto;
import com.example.hostelmanagementsystem.dto.ProspectiveStudentDto;
import com.example.hostelmanagementsystem.dto.Response.ResponseDto;
import com.example.hostelmanagementsystem.service.ProspectiveStudentService;
import com.example.hostelmanagementsystem.service.StudentService;
import com.example.hostelmanagementsystem.service.EligibleStudentManageService;
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
    private final EligibleStudentManageService eligibleStudentManageService;

    @PostMapping("/save-prospective-student")
    public ResponseEntity<ResponseDto> saveProspectiveStudent(@RequestBody ProspectiveStudentDto prospectiveStudentDto){
        return ResponseEntity.ok(prospectiveStudentService.saveProspectiveStudent(prospectiveStudentDto));
    }


    @PostMapping("/login")
    public ResponseEntity<ResponseDto> login(@RequestBody LoginDto loginDto){
        return ResponseEntity.ok(studentService.login(loginDto));
    }

    @GetMapping("/get-student-byID/{id}")
    public ResponseEntity<ResponseDto> getStudentById(@PathVariable Long id){
        return ResponseEntity.ok(prospectiveStudentService.getStudentById(id));

    }

    @GetMapping("/get-eligible-student/{email}")
    public ResponseEntity<ResponseDto> getEligibleStudentByEmail(@PathVariable String email){
       return ResponseEntity.ok(eligibleStudentManageService.getEligibleStudentByEmail(email));
    }

}
