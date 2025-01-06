package com.example.hostelmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DamageCaseDto {

    private Long id;
    private Long hostelId;
    private Double penalty_price;
    private String payment_status;
    private Long damageMasterId;
}
