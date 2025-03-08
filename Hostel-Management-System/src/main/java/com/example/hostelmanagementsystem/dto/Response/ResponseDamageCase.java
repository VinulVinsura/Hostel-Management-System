package com.example.hostelmanagementsystem.dto.Response;

import com.example.hostelmanagementsystem.dto.DamageMasterDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDamageCase {
    private Long id;
    private Long hostelId;
    private Double penalty_price;
    private String payment_status;
    private String studentId;
    private DamageMasterDto damageMaster;

}
