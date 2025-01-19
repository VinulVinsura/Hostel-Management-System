package com.example.hostelmanagementsystem.service.impl.admin;

import com.example.hostelmanagementsystem.dto.Response.ResponseDto;
import com.example.hostelmanagementsystem.dto.EligibleStudentDto;
import com.example.hostelmanagementsystem.dto.Response.ResponseEligibleStudentDto;
import com.example.hostelmanagementsystem.entity.EligibleStudent;
import com.example.hostelmanagementsystem.entity.HostelDetail;
import com.example.hostelmanagementsystem.repository.HostelDetailsRepo;
import com.example.hostelmanagementsystem.repository.EligibleStudentRepo;
import com.example.hostelmanagementsystem.service.security_service.JwtService;
import com.example.hostelmanagementsystem.service.EligibleStudentManageService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class EligibleStudentManageServiceImpl implements EligibleStudentManageService {
    private final EligibleStudentRepo eligibleStudentRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final ModelMapper modelMapper;
    private final HostelDetailsRepo hostelRepo;

    @Override
    public ResponseDto saveUser(EligibleStudentDto eligibleStudentDto) {

        try {

            EligibleStudent eligibleStudent = EligibleStudent.builder()
                    .firstName(eligibleStudentDto.getFirstName())
                    .lastName(eligibleStudentDto.getLastName())
                    .nameWithInitials(eligibleStudentDto.getNameWithInitials())
                    .nationalId(eligibleStudentDto.getNationalId())
                    .gender(eligibleStudentDto.getGender())
                    .email(eligibleStudentDto.getEmail())
                    .password(eligibleStudentDto.getPassword())
                    .studentId(eligibleStudentDto.getStudentId())
                    .contactNumber(eligibleStudentDto.getContactNumber())
                    .street(eligibleStudentDto.getStreet())
                    .village(eligibleStudentDto.getVillage())
                    .district(eligibleStudentDto.getDistrict())
                    .province(eligibleStudentDto.getProvince())
                    .postalCode(eligibleStudentDto.getPostalCode())
                    .distanceToHome(eligibleStudentDto.getDistanceToHome())
                    .mainIncome(eligibleStudentDto.getMainIncome())
                    .additionalIncome(eligibleStudentDto.getAdditionalIncome())
                    .numberFamilyMembers(eligibleStudentDto.getNumberFamilyMembers())
                    .numberOfSiblings(eligibleStudentDto.getNumberOfSiblings())
                    .numberOfSiblingsEdu(eligibleStudentDto.getNumberOfSiblingsEdu())
                    .nameOfGuardian(eligibleStudentDto.getNameOfGuardian())
                    .guardianContactNumber(eligibleStudentDto.getGuardianContactNumber())
                    .enrollDate(eligibleStudentDto.getEnrollDate())
                    .facultyName(eligibleStudentDto.getFacultyName())
                    .annualSalary(eligibleStudentDto.getAnnualSalary())
                    .hostel_detail(HostelDetail.builder().id(eligibleStudentDto.getHostel_id()).build())
                    .build();
            EligibleStudent saveEligibleStudent = eligibleStudentRepo.save(eligibleStudent);
            return new ResponseDto(00, saveEligibleStudent);


        }catch (Exception ex ){
            return new ResponseDto(02,"Error");
        }




    }

    @Override
    public ResponseDto getEligibleStudents() {
        try {
            List<EligibleStudent> eligibleStudentList = eligibleStudentRepo.findAll();
            List<ResponseEligibleStudentDto> responseEligibleStudentList=modelMapper.map(eligibleStudentList,
                    new TypeToken<List<ResponseEligibleStudentDto>>(){}.getType());
            return new ResponseDto(00,responseEligibleStudentList);

        }catch (Exception ex){
            return new ResponseDto(02,ex.getMessage());
        }
    }

    @Override
    public ResponseDto getEligibleStudentByEmail(String email) {
        try {
            Optional<EligibleStudent> student = eligibleStudentRepo.findByEmail(email);
            return new ResponseDto(00,modelMapper.map(student,
                    ResponseEligibleStudentDto.class));
        }catch (Exception ex){
            return new ResponseDto(02,ex.getMessage());
        }
    }
}
