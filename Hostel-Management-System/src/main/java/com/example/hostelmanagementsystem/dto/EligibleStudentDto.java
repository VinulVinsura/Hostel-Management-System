package com.example.hostelmanagementsystem.dto;

import com.example.hostelmanagementsystem.entity.DamageCase;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EligibleStudentDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String nameWithInitials;
    private String nationalId;
    private String gender;
    private String email;
    private String password;
    private String studentId;
    private String contactNumber;
    private String street;
    private String village;
    private String district;
    private String province;
    private Integer postalCode;
    private Integer distanceToHome;
    private String mainIncome;
    private String additionalIncome;
    private Integer numberFamilyMembers;
    private Integer numberOfSiblings;
    private Integer numberOfSiblingsEdu;
    private String nameOfGuardian;
    private String guardianContactNumber;;
    private String facultyName;
    private Integer annualSalary;

    private String enrollDate;
    private Long hostel_id;

}
