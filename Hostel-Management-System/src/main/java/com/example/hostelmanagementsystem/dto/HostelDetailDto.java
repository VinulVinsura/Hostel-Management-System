package com.example.hostelmanagementsystem.dto;


import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HostelDetailDto {
    private Long id;
    private String hostel_name;
    private String location;
    private Double contract_fee;
    private int total_rooms;
    private int total_capacity;
    private int filled_capacity;
    private int available_capacity;


}
