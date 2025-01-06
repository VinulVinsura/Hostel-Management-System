package com.example.hostelmanagementsystem.repository;

import com.example.hostelmanagementsystem.entity.DamageCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DamageCaseRepo extends JpaRepository<DamageCase ,Long> {
}
