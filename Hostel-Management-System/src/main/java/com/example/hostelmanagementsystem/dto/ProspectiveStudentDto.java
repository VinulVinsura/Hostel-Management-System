package com.example.hostelmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProspectiveStudentDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String nameWithInitials;
    private String nationalId;
    private String gender;
    private String email;
    private String password;
    private RoleDto userRole;
    private String studentId;
    private Integer contactNumber;
    private String street;
    private String village;
    private String district;
    private String province;
    private Integer postalCode;
    private BigDecimal distanceToHome;
    private String mainIncome;
    private String additionalIncome;
    private Integer numberFamilyMembers;
    private Integer numberOfSiblings;
    private Integer numberOfSiblingsEdu;
    private String nameOfGuardian;
    private String guardianContactNumber;
    private String status;
    private String facultyName;
    private BigDecimal annualSalary;



}
