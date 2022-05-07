package com.bookms.model;

import java.time.LocalDate;

import com.bookms.enumeration.Genre;

public class Movie {
	
	public Movie(int movieId, String movieName, int duration, String language, Genre genre, LocalDate releaseDate) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.duration = duration;
		this.language = language;
		this.genre = genre;
		this.releaseDate = releaseDate;
	}
	public int movieId;
	public String movieName;
	public int duration;
	public String language;
	public Genre genre;
	public LocalDate releaseDate;
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", duration=" + duration + ", language="
				+ language + ", genre=" + genre + ", releaseDate=" + releaseDate + "]";
	}
}
