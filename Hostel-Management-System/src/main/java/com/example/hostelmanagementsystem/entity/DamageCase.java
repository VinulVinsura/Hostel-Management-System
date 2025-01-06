package com.example.hostelmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class DamageCase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long hostelId;
    private Double penalty_price;
    private String payment_status;

    @ManyToOne
    @JoinColumn(name = "damageMaster")
    private DamageMaster damageMaster;

}
