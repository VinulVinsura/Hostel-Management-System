package com.example.hostelmanagementsystem.dto.Response;

import com.example.hostelmanagementsystem.dto.RoleDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private String password;
    private RoleDto userRole;
    private String studentId;
    private Integer contact_number;
    private String address;
    private String enroll_date;
    private String faculty_name;
}
