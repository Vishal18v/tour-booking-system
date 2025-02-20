package com.vishal.tour_booking_system.controller;

import com.vishal.tour_booking_system.model.Tour;
import com.vishal.tour_booking_system.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tours")
public class TourController {
    @Autowired
    private TourService tourService;

    @GetMapping
    public ResponseEntity<List<Tour>> getAllTours() {
        List<Tour> tours = tourService.getAllTours();
        return ResponseEntity.ok(tours);
    }

    @PostMapping
    public ResponseEntity<Tour> addTour(@RequestBody Tour tour) {
        Tour savedTour = tourService.addTour(tour);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTour);
    }
}

