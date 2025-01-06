package com.example.hostelmanagementsystem.repository;

import com.example.hostelmanagementsystem.entity.DamageMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DamageMasterRepo extends JpaRepository<DamageMaster,Long> {
}
