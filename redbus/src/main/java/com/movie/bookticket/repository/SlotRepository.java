package com.movie.bookticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.movie.bookticket.model.Slot;

@CrossOrigin(origins = "http://localhost:3000")
@RepositoryRestResource
public interface SlotRepository extends JpaRepository<Slot, Long> {
	
}
