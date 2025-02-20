package com.vishal.tour_booking_system.repository;

import com.vishal.tour_booking_system.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {
}

