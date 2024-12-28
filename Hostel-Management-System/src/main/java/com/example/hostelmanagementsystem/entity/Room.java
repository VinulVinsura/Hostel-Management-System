package com.example.hostelmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String roomId;

    private Integer room_capacity;
    private Integer filled_capacity;
    private String remark;

    @ManyToOne
    @JoinColumn(name = "hostelDetail")
    private HostelDetail hostelDetail;
}
