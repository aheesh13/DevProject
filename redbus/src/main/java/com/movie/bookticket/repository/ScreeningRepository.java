package com.movie.bookticket.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.movie.bookticket.model.Movie;
import com.movie.bookticket.model.Screening;
import com.movie.bookticket.model.Theater;

@CrossOrigin(origins = "http://localhost:3000")
@RepositoryRestResource
public interface ScreeningRepository extends JpaRepository<Screening, Long> {
    
    
	/*
	 * @Query("SELECT DISTINCT s.movie FROM Screening s WHERE s.theater.location.id = :locationId"
	 * ) List<Movie> findDistinctMoviesByTheaterLocationId(@Param("locationId") Long
	 * locationId);
	 * 
	 * @Query("SELECT DISTINCT s.theater FROM Screening s WHERE s.movie.id = :movieId AND s.theater.location.id = :locationId"
	 * ) List<Theater> findDistinctTheatersByMovieIdAndLocationId(@Param("movieId")
	 * Long movieId, @Param("locationId") Long locationId);
	 * 
	 * @Query("SELECT s FROM Screening s WHERE s.theater.location.id = :locationId AND s.theater.id = :theaterId AND s.date = :date"
	 * ) List<Screening> findByTheaterLocationIdAndDate(@Param("locationId") Long
	 * locationId, @Param("theaterId") Long theaterId, @Param("date") Date date);
	 */

}

