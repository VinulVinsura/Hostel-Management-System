package com.example.hostelmanagementsystem.repository;

import com.example.hostelmanagementsystem.entity.EligibleStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EligibleStudentRepo extends JpaRepository<EligibleStudent,Long> {

    Optional<EligibleStudent> findByEmail(String email);


}
