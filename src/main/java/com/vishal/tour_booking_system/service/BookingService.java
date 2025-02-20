package com.vishal.tour_booking_system.service;

import com.vishal.tour_booking_system.model.Booking;
import com.vishal.tour_booking_system.model.Tour;
import com.vishal.tour_booking_system.model.User;
import com.vishal.tour_booking_system.repository.BookingRepository;
import com.vishal.tour_booking_system.repository.TourRepository;
import com.vishal.tour_booking_system.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private TourRepository tourRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public synchronized Booking bookTour(Long tourId, String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Tour tour = tourRepository.findById(tourId)
                .orElseThrow(() -> new RuntimeException("Tour not found"));

        if (tour.getAvailableSeats() <= 0) {
            throw new RuntimeException("No seats available");
        }

        tour.setAvailableSeats(tour.getAvailableSeats() - 1);
        tourRepository.save(tour);

        Booking booking = new Booking();
        booking.setTour(tour);
        booking.setUser(user);
        booking.setBookingTime(LocalDateTime.now());
        return bookingRepository.save(booking);
    }

    public List<Booking> getUserBookings(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return bookingRepository.findByUser(user);
    }
}

