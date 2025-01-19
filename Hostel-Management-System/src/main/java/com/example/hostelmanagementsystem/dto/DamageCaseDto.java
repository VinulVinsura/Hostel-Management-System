package com.example.hostelmanagementsystem.dto;

import com.example.hostelmanagementsystem.entity.EligibleStudent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DamageCaseDto {

    private Long id;
    private Long hostelId;
    private Double penalty_price;
    private String payment_status;
    private String studentId;
    private Long damageMasterId;
//    private List<EligibleStudent> eligibleStudents;
}
