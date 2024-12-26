package com.example.hostelmanagementsystem.service.impl.student;

import com.example.hostelmanagementsystem.dto.LoginDto;
import com.example.hostelmanagementsystem.dto.Response.ResponseDto;
import com.example.hostelmanagementsystem.entity.Student;
import com.example.hostelmanagementsystem.repository.StudentRepo;
import com.example.hostelmanagementsystem.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;
    @Override
    public ResponseDto login(LoginDto loginDto) {

        Optional<Student> student = studentRepo.findByEmailAndStudentNum(loginDto.getEmail(), loginDto.getPassword());
        if (student.isEmpty()){
            return new ResponseDto(01,"Invalid Credential");
        }else {
            return new ResponseDto(0,student);
        }

    }
}
