package com.example.hostelmanagementsystem.service.impl.student;

import com.example.hostelmanagementsystem.dto.LoginDto;
import com.example.hostelmanagementsystem.dto.ProspectiveStudentDto;
import com.example.hostelmanagementsystem.dto.Response.ResponseDto;
import com.example.hostelmanagementsystem.entity.ProspectiveStudent;
import com.example.hostelmanagementsystem.repository.ProspectiveStudentRepo;
import com.example.hostelmanagementsystem.service.ProspectiveStudentService;
import com.example.hostelmanagementsystem.service.security_service.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProspectiveStudentServiceImpl implements ProspectiveStudentService {
    private final ProspectiveStudentRepo prospectiveStudentRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final ModelMapper modelMapper;
    private final AuthenticationManager authenticationManager;


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
                    .status(dto.getStatus())
                    .faculty_name(dto.getFaculty_name())
                    .address(dto.getAddress()).build();
            ProspectiveStudent p_student = prospectiveStudentRepo.save(prospectiveStudent);

            if(p_student!=null){
                return new ResponseDto(00,"Prospective Student Save Success..");
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
            return new ResponseDto(00,modelMapper.map(prospectiveStudentList, new TypeToken<List<ProspectiveStudentDto>>(){}.getType()));

        }catch (Exception ex){
            return new ResponseDto(03,ex.getMessage());
        }
    }

    @Override
    public ResponseDto login(LoginDto loginDto) {
        if(prospectiveStudentRepo.existsByEmail(loginDto.getEmail())){
            try {
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                loginDto.getEmail(),
                                loginDto.getPassword()
                        )
                );



            }catch (Exception ex){
                return new ResponseDto(02,ex.getMessage());
            }

        }else {
            return new ResponseDto(1,"Invalid Email");
        }

        ProspectiveStudent prospectiveStudent = prospectiveStudentRepo.findByEmail(loginDto.getEmail());
        String toke = jwtService.generateToke(prospectiveStudent);
        return new ResponseDto(00,toke);
    }
}
