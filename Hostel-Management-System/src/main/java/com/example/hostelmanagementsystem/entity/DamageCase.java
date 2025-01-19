package com.example.hostelmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class DamageCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long hostelId;
    private Double penalty_price;
    private String payment_status;
    private String StudentId;

    @ManyToOne
    @JoinColumn(name = "damageMaster")
    private DamageMaster damageMaster;
//
//    @ManyToMany(mappedBy = "damageCases",fetch = FetchType.LAZY)
//    @JsonBackReference
//    private List<EligibleStudent> eligibleStudents;

}
