package com.example.hostelmanagementsystem.repository;

import com.example.hostelmanagementsystem.dto.RoleDto;
import com.example.hostelmanagementsystem.entity.ProspectiveStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProspectiveStudentRepo extends JpaRepository<ProspectiveStudent,Long> {

    ProspectiveStudent findByEmail(String email);


    List<ProspectiveStudent> findAllByUserRole(RoleDto role);

    boolean existsByEmail(String email);

    List<ProspectiveStudent> findAllByAnnualSalaryLessThanAndDistanceToHomeGreaterThanAndGender(BigDecimal salary,
                                                                                              BigDecimal distance,
                                                                                              String gender);

        @Query("SELECT p FROM ProspectiveStudent p WHERE " +
                "(:salary IS NULL OR p.annualSalary < :salary) AND " +
                "(:distance IS NULL OR p.distanceToHome > :distance) AND " +
                "(:gender IS NULL OR p.gender = :gender) AND" +
                "(:userRole IS NULL OR p.userRole = :userRole)")
        List<ProspectiveStudent> findAllBySalaryOrDistanceOrGender(
                @Param("salary") BigDecimal salary,
                @Param("distance") BigDecimal distance,
                @Param("gender") String gender,
                @Param("userRole") RoleDto userRole);




}
