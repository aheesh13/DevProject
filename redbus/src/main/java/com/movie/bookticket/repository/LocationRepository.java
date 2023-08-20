package com.movie.bookticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.movie.bookticket.model.Location;

@RepositoryRestResource
public interface LocationRepository extends JpaRepository<Location, Long>{

}
