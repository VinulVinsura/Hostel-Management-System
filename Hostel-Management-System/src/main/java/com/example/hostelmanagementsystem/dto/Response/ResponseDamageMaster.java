package com.example.hostelmanagementsystem.dto.Response;

import com.example.hostelmanagementsystem.dto.DamageCaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDamageMaster {
    private Long  id;
    private String description;
    private Date damage_date;
    private Double damage_price;
    private List<DamageCaseDto> damageCases;

}
