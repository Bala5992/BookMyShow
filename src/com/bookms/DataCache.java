package com.bookms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bookms.model.CinemaHall;
import com.bookms.model.Movie;
import com.bookms.model.Show;
import com.bookms.model.User;

public class DataCache {
	
	private DataCache() {
	}

	public static List<Movie> MOVIES = new ArrayList<>();
	
	public static List<Show> SHOWS = new ArrayList<>();
	
	public static List<CinemaHall> CINEMAS = new ArrayList<>();
	
	public static Map<String, List<Show>> CITY_SHOWS = new HashMap<>();
	
	public static List<User> USERS = new ArrayList<>();
}
