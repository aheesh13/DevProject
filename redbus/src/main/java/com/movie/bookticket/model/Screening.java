package com.movie.bookticket.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "screening")
public class Screening {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;



	@Column(name = "available_seats")
    private int availableSeats;

	@ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;

    @Column(name = "date")
    private LocalDate date;

    @OneToOne(mappedBy = "screening")
    private TheaterLayout theaterLayout;

    public TheaterLayout getTheaterLayout() {
		return theaterLayout;
	}

	public void setTheaterLayout(TheaterLayout theaterLayout) {
		this.theaterLayout = theaterLayout;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
 }
