package com.example.hostelmanagementsystem.repository;

import com.example.hostelmanagementsystem.entity.HostelDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostelDetailsRepo extends JpaRepository<HostelDetail,Long> {

}
