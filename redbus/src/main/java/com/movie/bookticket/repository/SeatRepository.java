package com.movie.bookticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.movie.bookticket.model.Seat;


@RepositoryRestResource
public interface SeatRepository extends JpaRepository<Seat, Long>{

}