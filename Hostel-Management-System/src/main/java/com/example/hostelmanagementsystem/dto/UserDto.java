package com.example.hostelmanagementsystem.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

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
    private Long hostel_id;
}
