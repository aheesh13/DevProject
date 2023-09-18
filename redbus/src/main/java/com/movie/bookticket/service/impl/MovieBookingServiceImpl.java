package com.movie.bookticket.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.bookticket.model.Movie;
import com.movie.bookticket.model.Screening;
import com.movie.bookticket.model.Theater;
import com.movie.bookticket.repository.ScreeningRepository;

@Service
public class MovieBookingServiceImpl {
    @Autowired
    private ScreeningRepository screeningRepository;


    public String bookScreening(Long screeningId, int numberOfSeats) {
        Screening screening = screeningRepository.findById(screeningId).orElse(null);
        if (screening != null && screening.getAvailableSeats() >= numberOfSeats) {
            screening.setAvailableSeats(screening.getAvailableSeats() - numberOfSeats);
            screeningRepository.save(screening);
            return "Booking successful!";
        }
        return "Not enough available seats!";
    }

}
