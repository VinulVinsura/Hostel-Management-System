package com.example.hostelmanagementsystem.service;

import com.example.hostelmanagementsystem.dto.Response.ResponseDto;
import com.example.hostelmanagementsystem.dto.UserDto;

public interface UserManageService {

    ResponseDto saveUser(UserDto userDto);
    ResponseDto getEligibleStudents();
}
