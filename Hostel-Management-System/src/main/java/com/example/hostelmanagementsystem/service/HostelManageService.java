package com.example.hostelmanagementsystem.service;

import com.example.hostelmanagementsystem.dto.HostelDetailDto;
import com.example.hostelmanagementsystem.dto.Response.ResponseDto;
import com.example.hostelmanagementsystem.dto.Response.ResponseHostelDto;

public interface HostelManageService {
    ResponseDto addHostel(HostelDetailDto hostelDetailDto);
    ResponseDto getAllHostel();
}
