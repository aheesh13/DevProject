package com.movie.bookticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.bookticket.model.Theater;

public interface TheaterRepository extends JpaRepository<Theater, Long> {
	
}

