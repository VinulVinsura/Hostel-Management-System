package com.example.hostelmanagementsystem.service;

import com.example.hostelmanagementsystem.dto.Response.ResponseDto;
import com.example.hostelmanagementsystem.dto.EligibleStudentDto;

public interface EligibleStudentManageService {

    ResponseDto saveUser(EligibleStudentDto eligibleStudentDto);
    ResponseDto getEligibleStudents();
    ResponseDto getEligibleStudentByEmail(String email);
}
