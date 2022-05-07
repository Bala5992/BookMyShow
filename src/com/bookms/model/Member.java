package com.bookms.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.bookms.DataCache;

public class Member extends SystemMember {
	
	private static List<Booking> BOOKINGS = new ArrayList<Booking>();
	
	public Member(String userName, String password, String name) {
		super(userName, password, false);
		this.name = name;
	}
	
	Booking makeBooking(Booking booking) {
		BOOKINGS.add(booking);
		return booking;
	}
    List<Booking> getBooking() {
    	return BOOKINGS;
    }
    
    public void getMovies(LocalDate date, String City) {
    	if (DataCache.CITY_SHOWS.containsKey(City)) {
    		List<Show> shows = DataCache.CITY_SHOWS.get(City);
    		shows.stream().filter(show -> show.showDate.isEqual(date)).map(show -> {
    			return DataCache.MOVIES.stream().filter(mov -> mov.movieId == show.movieId).findAny().orElseGet(null);
    		}).forEach(System.out::println);
    	}
	}
	public void getCinemaHall(String City) {
		if (DataCache.CITY_SHOWS.containsKey(City)) {
    		List<Show> shows = DataCache.CITY_SHOWS.get(City);
    		shows.stream().map(show -> {
    			return DataCache.CINEMAS.stream().filter(cine -> cine.cinemaHallId == show.cinemaPlayedAt).findAny().orElseGet(null);
    		}).forEach(System.out::println);
    	}
	}
}
