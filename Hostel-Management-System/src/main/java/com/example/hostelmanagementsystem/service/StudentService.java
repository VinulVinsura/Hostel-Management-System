package com.example.hostelmanagementsystem.service;

import com.example.hostelmanagementsystem.dto.LoginDto;
import com.example.hostelmanagementsystem.dto.ResponseDto;

public interface StudentService {

    ResponseDto login(LoginDto loginDto);
}
