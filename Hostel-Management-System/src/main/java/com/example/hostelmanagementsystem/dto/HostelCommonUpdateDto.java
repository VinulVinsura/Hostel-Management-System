package com.example.hostelmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HostelCommonUpdateDto {

    private int upd_filled_capacity;
    private int upd_total_rooms;
    private int upd_room_filled_capacity;
    private String roomId;
}
