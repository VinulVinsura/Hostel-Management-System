package com.example.hostelmanagementsystem.dto.Response;

import com.example.hostelmanagementsystem.dto.HostelDetailDto;
import com.example.hostelmanagementsystem.dto.RoleDto;
import com.example.hostelmanagementsystem.entity.DamageCase;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEligibleStudentDto {
//    private Long id;
//    private String firstName;
//    private String lastName;
//    private String gender;
//    private String email;
//    private String password;
//    private RoleDto userRole;
//    private String studentId;
//    private Integer contact_number;
//    private String address;
//    private String enroll_date;
//    private String faculty_name;
//    private HostelDetailDto hostel_detail;

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
    private String roomId;
    private HostelDetailDto hostel_detail;
}
