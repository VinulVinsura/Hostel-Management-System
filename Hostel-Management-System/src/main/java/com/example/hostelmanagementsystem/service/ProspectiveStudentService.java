package com.example.hostelmanagementsystem.service;

import com.example.hostelmanagementsystem.dto.ProspectiveStudentDto;
import com.example.hostelmanagementsystem.dto.ResponseDto;

public interface ProspectiveStudentService {
    ResponseDto saveProspectiveStudent(ProspectiveStudentDto dto);
    ResponseDto getAllProspectiveStudent();
}
