package com.example.hostelmanagementsystem.dto.Response;

import com.example.hostelmanagementsystem.dto.HostelDetailDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseRoomDto {
    private Long id;
    private String roomId;
    private Integer room_capacity;
    private Integer filled_capacity;
    private String remark;
    private HostelDetailDto hostelDetail;

}
