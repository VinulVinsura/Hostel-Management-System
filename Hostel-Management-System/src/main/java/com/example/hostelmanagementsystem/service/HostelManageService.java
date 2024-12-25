package com.example.hostelmanagementsystem.service;

import com.example.hostelmanagementsystem.dto.HostelDetailDto;
import com.example.hostelmanagementsystem.dto.ResponseDto;

public interface HostelManageService {
    ResponseDto addHostel(HostelDetailDto hostelDetailDto);
    ResponseDto getAllHostel();
}
