package com.example.hostelmanagementsystem.service.impl;

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

@Service
@RequiredArgsConstructor
@Transactional
public class UserManageServiceImpl implements UserManageService {
    private final UserRepo userRepo;
    private final ModelMapper modelMapper;
    private final HostelDetailsRepo hostelDetailsRepo;
    @Override
    public UserDto saveUser(UserDto userDto) {


        HostelDetail hostelDetail = new HostelDetail(userDto.getHostel_id());


        User user= new User(null,
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getGender(),
                userDto.getEmail(),
                userDto.getPassword(),
                userDto.getUserRole(),
                userDto.getStudentId(),
                userDto.getContact_number(),
                userDto.getAddress(),
                userDto.getEnroll_date(),
                userDto.getFaculty_name(),
                hostelDetail
                );
          User user1=userRepo.save(user);
          return modelMapper.map(user1, UserDto.class);

    }
}
