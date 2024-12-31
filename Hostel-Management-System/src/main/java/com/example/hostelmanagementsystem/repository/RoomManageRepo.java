package com.example.hostelmanagementsystem.repository;

import com.example.hostelmanagementsystem.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomManageRepo extends JpaRepository<Room,Long> {

    boolean existsByRoomId(String roomId);
    Room findByRoomId(String roomId);
}
