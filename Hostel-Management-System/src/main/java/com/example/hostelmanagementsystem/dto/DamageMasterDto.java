package com.example.hostelmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DamageMasterDto {
    private Long  id;
    private String description;
    private Date damage_date;
    private Double damage_price;

}
