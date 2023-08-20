package com.movie.bookticket.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.movie.bookticket.model.Screening;

@RepositoryRestResource
public interface ScreeningRepository extends JpaRepository<Screening, Long> {
    List<Screening> findByTheaterLocationIdAndDate(Long locationId, Date date);
}

