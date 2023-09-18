package com.movie.bookticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.movie.bookticket.model.Theater;

@CrossOrigin(origins = "http://localhost:3000")
@RepositoryRestResource
public interface TheaterRepository extends JpaRepository<Theater, Long> {
	/*
	 * List<Theater> findByLocationId(Long locationId);
	 * 
	 * @Query("SELECT DISTINCT s.theater FROM Screening s WHERE s.movie.id = :movieId AND s.theater.location.id = :locationId"
	 * ) List<Theater> findDistinctTheatersByMovieIdAndLocationId(@Param("movieId")
	 * Long movieId, @Param("locationId") Long locationId);
	 */
	}

