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
import java.util.Optional;

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

    @Override
    public ResponseDto getRoomByRoomId(String roomId) {
        try {
            if(roomManageRepo.existsByRoomId(roomId)){
                Room room = roomManageRepo.findByRoomId(roomId);
                return new ResponseDto(00,modelMapper.map(room, ResponseRoomDto.class));
            }else {
                return new ResponseDto(01,"Invalid Room ID");
            }
        }catch (Exception ex) {
            return new ResponseDto(02,ex.getMessage());
        }
    }

    @Override
    public ResponseDto updateRoom(Long id, RoomDto updateRoomDto) {
        try {
            Optional<Room> room = roomManageRepo.findById(id);
            room.get().setRoomId(updateRoomDto.getRoomId());
            room.get().setRoom_capacity(updateRoomDto.getRoom_capacity());
            room.get().setFilled_capacity(updateRoomDto.getFilled_capacity());
            room.get().setRemark(updateRoomDto.getRemark());
            room.get().setHostelDetail(HostelDetail.builder().id(updateRoomDto.getHostel_id()).build());
            Room updatedRoom = roomManageRepo.save(room.get());

            return new ResponseDto(00,modelMapper.map(updatedRoom, ResponseRoomDto.class));


        }catch (Exception ex){
            return new ResponseDto(02,ex.getMessage());
        }
    }
}
