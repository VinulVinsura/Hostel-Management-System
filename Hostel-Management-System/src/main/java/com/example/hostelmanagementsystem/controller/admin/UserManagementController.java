package com.example.hostelmanagementsystem.controller.admin;

import com.example.hostelmanagementsystem.dto.Response.ResponseDto;
import com.example.hostelmanagementsystem.dto.EligibleStudentDto;
import com.example.hostelmanagementsystem.service.ProspectiveStudentService;
import com.example.hostelmanagementsystem.service.EligibleStudentManageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/user")
@Slf4j
@CrossOrigin("*")
@RequiredArgsConstructor
public class UserManagementController {

    @Autowired
    private EligibleStudentManageService eligibleStudentManageService;
    private final ProspectiveStudentService prospectiveStudentService;

    @PostMapping("/save-user")
    public ResponseEntity<ResponseDto> saveUser(@RequestBody EligibleStudentDto eligibleStudentDto){
        try {
            log.info("done");
            return ResponseEntity.ok(eligibleStudentManageService.saveUser(eligibleStudentDto));
        }catch (UnexpectedRollbackException ex){
            log.error("Error");
            return ResponseEntity.ok(new ResponseDto(02,ex.getMessage()));
        }
    }

    // (/api/user/get-all-eligible-student)
    @GetMapping("/get-all-eligible-student")
    public ResponseEntity<ResponseDto> getEligibleStudents(){
        return ResponseEntity.ok(eligibleStudentManageService.getEligibleStudents());
    }

    @GetMapping("/get-all-prospective-student")
    public ResponseEntity<ResponseDto> getAllProspectiveStudent(){
        return ResponseEntity.status(HttpStatus.OK).body(prospectiveStudentService.getAllProspectiveStudent());
    }

    @GetMapping("/get-all-bySalaryOrDistanceOrGender")
    public ResponseEntity<ResponseDto> getAllProspectiveStudentBySalaryOrDistanceOrGender(
            @RequestParam(required = false) BigDecimal salary,
            @RequestParam(required = false) BigDecimal distance,
            @RequestParam(required = false) String gender
    ){

        System.err.println("-----------------------");
//        log.info(salary.toString() +" "+ distance +" "+gender);
        return ResponseEntity.status(HttpStatus.OK).body(prospectiveStudentService.getAllProspectiveBySalaryOrDistanceOrGender(
                salary,distance,gender
        ));
    }
}
