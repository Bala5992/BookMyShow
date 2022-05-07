package com.bookms.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Show {
	
	public Show(int showId, int movieId, LocalDate showDate, LocalTime startTime, int cinemaPlayedAt,
			List<Seat> seats) {
		super();
		this.showId = showId;
		this.movieId = movieId;
		this.showDate = showDate;
		this.startTime = startTime;
		this.cinemaPlayedAt = cinemaPlayedAt;
		this.seats = seats;
	}
	public int showId;
	public int movieId;
	public LocalDate showDate;
	public LocalTime startTime;
	public LocalTime endTime;

	public int cinemaPlayedAt;
	public List<Seat> seats;
	@Override
	public String toString() {
		return "Show [showId=" + showId + ", movieId=" + movieId + ", showDate=" + showDate + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", cinemaPlayedAt=" + cinemaPlayedAt + ", seats=" + seats + "]";
	}
	
}
