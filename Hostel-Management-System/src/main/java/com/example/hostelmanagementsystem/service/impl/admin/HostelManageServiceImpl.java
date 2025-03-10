package com.example.hostelmanagementsystem.service.impl.admin;

import com.example.hostelmanagementsystem.dto.HostelCommonUpdateDto;
import com.example.hostelmanagementsystem.dto.HostelDetailDto;
import com.example.hostelmanagementsystem.dto.Response.ResponseDto;
import com.example.hostelmanagementsystem.dto.Response.ResponseHostelDto;
import com.example.hostelmanagementsystem.entity.HostelDetail;
import com.example.hostelmanagementsystem.entity.Room;
import com.example.hostelmanagementsystem.repository.HostelDetailsRepo;
import com.example.hostelmanagementsystem.repository.RoomManageRepo;
import com.example.hostelmanagementsystem.service.HostelManageService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class HostelManageServiceImpl implements HostelManageService {
    private final ModelMapper modelMapper;
    private final HostelDetailsRepo hostelRepo;
    private final RoomManageRepo roomManageRepo;
    @Override
    public ResponseDto addHostel(HostelDetailDto hostelDetailDto) {

        try {
            HostelDetail build = HostelDetail.builder()
                    .hostel_name(hostelDetailDto.getHostel_name())
                    .location(hostelDetailDto.getLocation())
                    .contract_fee(hostelDetailDto.getContract_fee())
                    .total_rooms(hostelDetailDto.getTotal_rooms())
                    .total_capacity(hostelDetailDto.getTotal_capacity())
                    .filled_capacity(hostelDetailDto.getFilled_capacity())
                    .available_capacity(hostelDetailDto.getTotal_capacity() - hostelDetailDto.getFilled_capacity()).build();
            HostelDetail hostelDetail=hostelRepo.save(build);
            return new ResponseDto(00,hostelDetail);
        }catch (Exception ex){
            return new ResponseDto(02,ex.getMessage());
        }



    }

    @Override
    public ResponseDto getAllHostel() {

        try {
            List<HostelDetail> hostelDetailList = hostelRepo.findAll();
            List<ResponseHostelDto> responseHostelDtoList=modelMapper.map(hostelDetailList,
                    new TypeToken<List<ResponseHostelDto>>(){}.getType());
            return new ResponseDto(00,responseHostelDtoList);

        }catch (Exception ex){
            return new ResponseDto(02,ex.getMessage());
        }
    }

    @Override
    @Transactional
    public ResponseDto updateHostelCapacity(Long id, HostelCommonUpdateDto commonUpdateDto) {
        try {
            Optional<HostelDetail> hostelDetail = hostelRepo.findById(id);

            hostelDetail.get().setFilled_capacity(hostelDetail.get().getFilled_capacity()+ commonUpdateDto.getUpd_filled_capacity());
            hostelDetail.get().setAvailable_capacity(hostelDetail.get().getTotal_capacity()- hostelDetail.get().getFilled_capacity());
            hostelDetail.get().setTotal_rooms(hostelDetail.get().getTotal_rooms()+ commonUpdateDto.getUpd_total_rooms());
            HostelDetail save = hostelRepo.save(hostelDetail.get());
            if(save==null){
                return new ResponseDto(02,"update error");
            }
            Room room = roomManageRepo.findByRoomId(commonUpdateDto.getRoomId());
            room.setFilled_capacity(room.getFilled_capacity()+commonUpdateDto.getUpd_room_filled_capacity());

            roomManageRepo.save(room);
            return new ResponseDto(00,"success");

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseDto(01,e.getMessage());
        }

    }
}
