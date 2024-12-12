package com.example.hostelmanagementsystem.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String email;
    private String password;
    private RoleDto userRole;
    private String studentId;
    private Integer contact_number;
    private String houseNumber;
    private String street;
    private String city;
    private String district;
    private String enroll_date;
    private String faculty_name;
}
