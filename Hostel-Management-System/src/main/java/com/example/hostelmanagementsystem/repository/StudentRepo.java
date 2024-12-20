package com.example.hostelmanagementsystem.repository;

import com.example.hostelmanagementsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student,String> {

    Optional<Student> findByEmailAndStudentNum(String email, String studentNum);

}
