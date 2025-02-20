package com.vishal.tour_booking_system.controller;

import com.vishal.tour_booking_system.model.Booking;
import com.vishal.tour_booking_system.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("/book")
    public ResponseEntity<Booking> bookTour(@RequestParam Long tourId, @RequestParam String email) {
        Booking booking = bookingService.bookTour(tourId, email);
        return ResponseEntity.status(HttpStatus.CREATED).body(booking);
    }

    @GetMapping("/user")
    public ResponseEntity<List<Booking>> getUserBookings(@RequestParam String email) {
        List<Booking> bookings = bookingService.getUserBookings(email);
        if (bookings.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(bookings);
        }
        return ResponseEntity.ok(bookings);
    }
}

