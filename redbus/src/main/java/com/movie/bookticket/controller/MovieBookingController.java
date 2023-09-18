package com.movie.bookticket.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movie.bookticket.model.Location;
import com.movie.bookticket.model.Movie;
import com.movie.bookticket.model.Screening;
import com.movie.bookticket.model.Theater;
import com.movie.bookticket.repository.LocationRepository;
import com.movie.bookticket.repository.SeatRepository;
import com.movie.bookticket.repository.TheaterRepository;
import com.movie.bookticket.service.impl.MovieBookingServiceImpl;



@RestController
@RequestMapping("/api/movies")
public class MovieBookingController {
    @Autowired
    private MovieBookingServiceImpl movieBookingService;
    @Autowired
    private LocationRepository locationRepo;
    @Autowired
    private TheaterRepository theaterRepo;
    @Autowired
    private SeatRepository seatRepo;

    
    @GetMapping("/locations")
    public List<Location> getAllLocations() {
        return locationRepo.findAll();
    }
    
 

    @PostMapping("/book/{screeningId}")
    public String makeBooking(@PathVariable Long screeningId, @RequestParam int numberOfSeats) {
        return movieBookingService.bookScreening(screeningId, numberOfSeats);
    }
    
    
    
}