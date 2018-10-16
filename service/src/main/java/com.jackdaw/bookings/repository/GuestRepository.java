package com.jackdaw.bookings.repository;

import com.jackdaw.bookings.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Integer> {
}
