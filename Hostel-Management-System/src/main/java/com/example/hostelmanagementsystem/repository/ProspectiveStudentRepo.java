package com.example.hostelmanagementsystem.repository;

import com.example.hostelmanagementsystem.entity.ProspectiveStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProspectiveStudentRepo extends JpaRepository<ProspectiveStudent,Long> {

    ProspectiveStudent findByEmail(String email);
    boolean existsByEmail(String email);
}
