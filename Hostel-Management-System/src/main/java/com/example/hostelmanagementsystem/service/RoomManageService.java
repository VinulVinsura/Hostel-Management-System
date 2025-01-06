package com.example.hostelmanagementsystem.service;

import com.example.hostelmanagementsystem.dto.Response.ResponseDto;
import com.example.hostelmanagementsystem.dto.RoomDto;

public interface RoomManageService {

    ResponseDto addRoom(RoomDto roomDto);
    ResponseDto getAllRoom();
    ResponseDto getRoomByRoomId(String roomId);

    ResponseDto updateRoom(Long id, RoomDto roomDto);
}
