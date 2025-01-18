package com.example.hostelmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hostel_detail")
public class HostelDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String hostel_name;
    private String location;
    private Double contract_fee;
    private int total_rooms;
    private int total_capacity;
    private int filled_capacity;
    private int available_capacity;

    @OneToMany(mappedBy = "hostel_detail")
//    @JsonIgnore
    private List<EligibleStudent> eligibleStudents;

    @OneToMany(mappedBy = "hostelDetail")
    private List<Room> rooms;


//    //user find by ID
//    public HostelDetail(Long id) {
//        this.id = id;
//    }
}
