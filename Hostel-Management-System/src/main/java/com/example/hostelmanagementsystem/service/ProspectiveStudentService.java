package com.example.hostelmanagementsystem.service;

import com.example.hostelmanagementsystem.dto.LoginDto;
import com.example.hostelmanagementsystem.dto.ProspectiveStudentDto;
import com.example.hostelmanagementsystem.dto.Response.ResponseDto;

public interface ProspectiveStudentService {
    ResponseDto saveProspectiveStudent(ProspectiveStudentDto dto);
    ResponseDto getAllProspectiveStudent();
    ResponseDto login(LoginDto loginDto);
    ResponseDto getStudentById(Long id);
}
