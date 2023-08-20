package com.movie.bookticket.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movie.bookticket.model.Location;
import com.movie.bookticket.model.Screening;
import com.movie.bookticket.model.Seat;
import com.movie.bookticket.model.Slot;
import com.movie.bookticket.model.Theater;
import com.movie.bookticket.repository.LocationRepository;
import com.movie.bookticket.repository.ScreeningRepository;
import com.movie.bookticket.repository.SeatRepository;
import com.movie.bookticket.repository.SlotRepository;
import com.movie.bookticket.repository.TheaterRepository;
import com.movie.bookticket.service.impl.MovieBookingService;
import com.movie.bookticket.service.impl.MovieBookingServiceImpl;



@RestController
@RequestMapping("/api/movies")
public class MovieBookingController {
    @Autowired
    private MovieBookingServiceImpl movieBookingService;
    
    @Autowired
    private LocationRepository locationRepo;
    
    @Autowired
    private ScreeningRepository screenRepo;
    
    @Autowired
    private SlotRepository slotRepo;
    
    @Autowired
    private TheaterRepository theaterRepo;
    
    @Autowired
    private SeatRepository seatRepo;

    @GetMapping("/screenings")
    public List<Screening> getScreenings(@RequestParam Long locationId, @RequestParam Date date) {
        return movieBookingService.getAvailableScreenings(locationId, date);
    }

    
    @PostMapping("/book/{screeningId}")
    public String makeBooking(@PathVariable Long screeningId, @RequestParam int numberOfSeats) {
        return movieBookingService.bookScreening(screeningId, numberOfSeats);
    }
    
    
    
}