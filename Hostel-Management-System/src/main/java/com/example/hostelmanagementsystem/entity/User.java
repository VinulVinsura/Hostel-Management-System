package com.example.hostelmanagementsystem.entity;

import com.example.hostelmanagementsystem.dto.RoleDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String gender;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String password;

    @Column(nullable = false)
    private RoleDto userRole;

    @Column(unique = true)
    private String studentId;

    private Integer contact_number;
    private String address;
    private String enroll_date;
    private String faculty_name;

    @ManyToOne
    @JoinColumn(name = "hostel_detail" )
    private HostelDetail hostel_detail;


}
