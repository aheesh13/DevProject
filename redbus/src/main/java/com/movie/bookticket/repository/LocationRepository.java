package com.movie.bookticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.bookticket.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long>{

}
