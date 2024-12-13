package com.example.hostelmanagementsystem.service.impl;

import com.example.hostelmanagementsystem.dto.ResponseDto;
import com.example.hostelmanagementsystem.dto.UserDto;
import com.example.hostelmanagementsystem.entity.HostelDetail;
import com.example.hostelmanagementsystem.entity.User;
import com.example.hostelmanagementsystem.repository.HostelDetailsRepo;
import com.example.hostelmanagementsystem.repository.UserRepo;
import com.example.hostelmanagementsystem.service.UserManageService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.UnexpectedRollbackException;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional
public class UserManageServiceImpl implements UserManageService {
    private final UserRepo userRepo;
    private final ModelMapper modelMapper;
    private final HostelDetailsRepo hostelRepo;

    @Override
    public ResponseDto saveUser(UserDto userDto) {

        try {
            User user = User.builder()
                    .firstName(userDto.getFirstName())
                    .lastName(userDto.getLastName())
                    .gender(userDto.getGender())
                    .email(userDto.getEmail())
                    .password(userDto.getPassword())
                    .userRole(userDto.getUserRole())
                    .studentId(userDto.getStudentId())
                    .contact_number(userDto.getContact_number())
                    .address(userDto.getAddress())
                    .enroll_date(userDto.getEnroll_date())
                    .faculty_name(userDto.getFaculty_name())
                    .hostel_detail(HostelDetail.builder().id(userDto.getHostel_id()).build())
                    .build();
            User saveUser=userRepo.save(user);
            return new ResponseDto(00,saveUser);


        }catch (Exception ex ){
            return new ResponseDto(02,"Error");
        }




    }
}
