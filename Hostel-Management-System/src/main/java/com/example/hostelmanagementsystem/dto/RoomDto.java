package com.example.hostelmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {
    private Long id;
    private String roomId;
    private Integer room_capacity;
    private Integer filled_capacity;
    private String remark;
    private Long hostel_id;
}
