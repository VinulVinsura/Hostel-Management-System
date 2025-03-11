package com.example.hostelmanagementsystem.service;

import com.example.hostelmanagementsystem.dto.LoginDto;
import com.example.hostelmanagementsystem.dto.ProspectiveStudentDto;
import com.example.hostelmanagementsystem.dto.Response.ResponseDto;

import java.math.BigDecimal;

public interface ProspectiveStudentService {
    ResponseDto saveProspectiveStudent(ProspectiveStudentDto dto);
    ResponseDto getAllProspectiveStudent();
    ResponseDto login(LoginDto loginDto);
    ResponseDto getStudentById(Long id);

    ResponseDto getAllProspectiveBySalaryOrDistanceOrGender(BigDecimal salary, BigDecimal distance, String gender);

    ResponseDto updateStatus(String id, String status);
}
