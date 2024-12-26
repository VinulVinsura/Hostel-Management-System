package com.example.hostelmanagementsystem.service.impl.admin;

import com.example.hostelmanagementsystem.dto.HostelDetailDto;
import com.example.hostelmanagementsystem.dto.Response.ResponseDto;
import com.example.hostelmanagementsystem.dto.Response.ResponseHostelDto;
import com.example.hostelmanagementsystem.entity.HostelDetail;
import com.example.hostelmanagementsystem.repository.HostelDetailsRepo;
import com.example.hostelmanagementsystem.service.HostelManageService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class HostelManageServiceImpl implements HostelManageService {
    private final ModelMapper modelMapper;
    private final HostelDetailsRepo hostelRepo;
    @Override
    public ResponseDto addHostel(HostelDetailDto hostelDetailDto) {

        try {
            HostelDetail hostelDetail=hostelRepo.save(modelMapper.map(hostelDetailDto, HostelDetail.class));
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
}
