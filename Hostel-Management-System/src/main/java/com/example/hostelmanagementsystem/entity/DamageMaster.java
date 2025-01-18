package com.example.hostelmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class DamageMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
    private String description;
    private Date damage_date;
    private Double damage_price;

    @OneToMany(mappedBy = "damageMaster")
    private  List<DamageCase> damageCases;

}
