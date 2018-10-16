package com.jackdaw.bookings.repository;

import com.jackdaw.bookings.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {
}
