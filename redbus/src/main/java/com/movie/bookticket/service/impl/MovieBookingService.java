package com.movie.bookticket.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.movie.bookticket.model.Screening;
import com.movie.bookticket.model.Theater;

public interface MovieBookingService {

	
	public List<Screening>getAvailableScreenings(Long locationId, Long theaterId, Date date);
	public String bookScreening(Long screeningId, int numberOfSeats);
//	public List<String>getAllBusOnDest(String dest);
	
}
