package com.movie.bookticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.movie.bookticket.model.Slot;

@RepositoryRestResource
public interface SlotRepository extends JpaRepository<Slot, Long> {
	
}
