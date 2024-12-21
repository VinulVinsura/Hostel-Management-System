package com.example.hostelmanagementsystem.service.impl.student;

import com.example.hostelmanagementsystem.dto.ProspectiveStudentDto;
import com.example.hostelmanagementsystem.dto.ResponseDto;
import com.example.hostelmanagementsystem.entity.ProspectiveStudent;
import com.example.hostelmanagementsystem.repository.ProspectiveStudentRepo;
import com.example.hostelmanagementsystem.service.ProspectiveStudentService;
import com.example.hostelmanagementsystem.service.security_service.JwtService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProspectiveStudentServiceImpl implements ProspectiveStudentService {
    private final ProspectiveStudentRepo prospectiveStudentRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final ModelMapper modelMapper;


    @Override
    public ResponseDto saveProspectiveStudent(ProspectiveStudentDto dto) {
        try {
            ProspectiveStudent prospectiveStudent=ProspectiveStudent.builder()
                    .firstName(dto.getFirstName())
                    .lastName(dto.getLastName())
                    .gender(dto.getGender())
                    .email(dto.getEmail())
                    .password(passwordEncoder.encode(dto.getPassword()))
                    .userRole(dto.getUserRole())
                    .studentId(dto.getStudentId())
                    .contact_number(dto.getContact_number())
                    .faculty_name(dto.getFaculty_name())
                    .address(dto.getAddress()).build();
            ProspectiveStudent p_student = prospectiveStudentRepo.save(prospectiveStudent);
            String token = jwtService.generateToke(p_student);

            if(p_student!=null){
                return new ResponseDto(00,token);
            }else {
                return new ResponseDto(01,"Prospective Student Not Save");
            }

        }catch (Exception ex){
            return new ResponseDto(03,ex.getMessage());
        }


    }

    @Override
    public ResponseDto getAllProspectiveStudent() {
        try {
            List<ProspectiveStudent> prospectiveStudentList = prospectiveStudentRepo.findAll();
            if(prospectiveStudentList.isEmpty()){
                return new ResponseDto(01,"Prospective Student Is Empty");
            }
            return new ResponseDto(00,modelMapper.map(prospectiveStudentList,new TypeToken<List<ProspectiveStudentDto>>(){}.getType()));

        }catch (Exception ex){
            return new ResponseDto(03,ex.getMessage());
        }


    }
}
