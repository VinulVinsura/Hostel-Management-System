package com.example.hostelmanagementsystem.service.impl.admin;

import com.example.hostelmanagementsystem.dto.Response.ResponseDto;
import com.example.hostelmanagementsystem.dto.Response.ResponseRoomDto;
import com.example.hostelmanagementsystem.dto.RoomDto;
import com.example.hostelmanagementsystem.entity.HostelDetail;
import com.example.hostelmanagementsystem.entity.Room;
import com.example.hostelmanagementsystem.repository.RoomManageRepo;
import com.example.hostelmanagementsystem.service.RoomManageService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomManageServiceImpl implements RoomManageService {

    private final RoomManageRepo roomManageRepo;
    private final ModelMapper modelMapper;
    @Override
    public ResponseDto addRoom(RoomDto roomDto) {
        try {
            if (roomManageRepo.existsByRoomId(roomDto.getRoomId())){
                return new ResponseDto(00,roomDto.getRoomId()+" already exists..");
            }else {
                Room room=Room.builder()
                        .roomId(roomDto.getRoomId())
                        .room_capacity(roomDto.getRoom_capacity())
                        .filled_capacity(roomDto.getFilled_capacity())
                        .remark(roomDto.getRemark())
                        .hostelDetail(HostelDetail.builder().id(roomDto.getHostel_id()).build())
                        .build();
                Room saved_room = roomManageRepo.save(room);
                return new ResponseDto(00,"Room Add Success...");

            }
        }catch (Exception e){
            return new ResponseDto(02,e.getMessage());
        }

    }

    @Override
    public ResponseDto getAllRoom() {

        try {
            List<Room> roomList = roomManageRepo.findAll();
            List<ResponseRoomDto> responseRoomDtoList=modelMapper.map(roomList,
                    new TypeToken<List<ResponseRoomDto>>(){}.getType());
            return new ResponseDto(00,responseRoomDtoList);

        }catch (Exception ex){
            return new ResponseDto(02,ex.getMessage());
        }
    }
}
