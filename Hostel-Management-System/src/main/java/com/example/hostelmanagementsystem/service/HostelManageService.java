package com.example.hostelmanagementsystem.service;

import com.example.hostelmanagementsystem.dto.HostelDetailDto;
import com.example.hostelmanagementsystem.dto.ResponseDto;

public interface HostelManageService {
    public ResponseDto addHostel(HostelDetailDto hostelDetailDto);
}
