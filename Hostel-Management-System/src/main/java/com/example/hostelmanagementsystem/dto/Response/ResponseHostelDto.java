package com.example.hostelmanagementsystem.dto.Response;

import com.example.hostelmanagementsystem.dto.EligibleStudentDto;
import com.example.hostelmanagementsystem.dto.RoomDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseHostelDto {
    private Long id;
    private String hostel_name;
    private String location;
    private Double contract_fee;
    private int total_rooms;
    private int total_capacity;
    private int filled_capacity;
    private int available_capacity;
    private List<EligibleStudentDto> eligibleStudents;
    private List<RoomDto> rooms;
}
