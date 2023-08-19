package com.movie.bookticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.bookticket.model.Slot;

public interface SlotRepository extends JpaRepository<Slot, Long> {
	
}
