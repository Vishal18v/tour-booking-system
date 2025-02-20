package com.vishal.tour_booking_system.repository;

import com.vishal.tour_booking_system.model.Booking;
import com.vishal.tour_booking_system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUser(User user);
}