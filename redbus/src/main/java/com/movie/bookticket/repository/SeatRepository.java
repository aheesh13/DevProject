package com.movie.bookticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.movie.bookticket.model.Seat;
import com.movie.bookticket.model.Theater;

@CrossOrigin(origins = "http://localhost:3000")
@RepositoryRestResource
public interface SeatRepository extends JpaRepository<Seat, Long>{
	//List<Seat> findByScreeningId(Long screeningId);
}