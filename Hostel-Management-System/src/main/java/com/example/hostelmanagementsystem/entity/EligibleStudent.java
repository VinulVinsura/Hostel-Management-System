package com.example.hostelmanagementsystem.entity;

import com.example.hostelmanagementsystem.dto.RoleDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EligibleStudent")
public class EligibleStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String nameWithInitials;
    private String nationalId;
    private String gender;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false,unique = true)
    private String password;

    @Column(nullable = false,unique = true)
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
    private String guardianContactNumber;
    private String facultyName;
    private Integer annualSalary;
    private String enrollDate;
    @ManyToOne
    @JoinColumn(name = "hostel_detail" )
    private HostelDetail hostel_detail;

//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(name = "Student_has_Damage_Case",
//            joinColumns = {
//                    @JoinColumn(name = "student_id", referencedColumnName = "id")
//            },
//            inverseJoinColumns = {
//                    @JoinColumn(name = "damage_case_id", referencedColumnName = "id")
//            }
//    )
//    @JsonManagedReference
//    @Column(nullable = true)
//    private List<DamageCase> damageCases;


}
