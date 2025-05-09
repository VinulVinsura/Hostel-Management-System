package com.example.hostelmanagementsystem.repository;

import com.example.hostelmanagementsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student,String> {

    Optional<Student> findByEmailAndStudentNum(String email, String studentNum);

}
