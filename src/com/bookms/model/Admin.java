package com.bookms.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bookms.DataCache;

public class Admin extends SystemMember {
	
	public Admin(String userName, String password, String name) {
		super(userName, password, true);
		this.name = name;
	}
	
	public boolean addMovie(Movie movie) {
		return DataCache.MOVIES.add(movie);
	}
	
	public boolean addShow(Show show) {
    	return DataCache.SHOWS.add(show);
    }
	
	public boolean addCinema(CinemaHall cinemaHall) {
    	return DataCache.CINEMAS.add(cinemaHall);
    }
	public void prepare() {
		DataCache.SHOWS.stream().forEach(show -> {
			Optional<CinemaHall> cinemaHall = DataCache.CINEMAS.stream().filter(cinema -> cinema.cinemaHallId == show.cinemaPlayedAt).findFirst();
			if (cinemaHall.isPresent()) {
				DataCache.CITY_SHOWS.compute(cinemaHall.get().adress.city, (a, b) -> {
					if (b == null) {
						List<Show> t1 = new ArrayList<>();
						t1.add(show);
						return t1;
					} 
					b.add(show);
					return b;
				});
			}
		});
	}
}
