package com.bookms.model;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.bookms.DataCache;
import com.bookms.enumeration.Genre;

public class Search {
	public List<Movie> searchMovieByNames(String name) {
		return DataCache.MOVIES.stream().filter(movie -> movie.movieName.equals(name)).collect(Collectors.toList());
	}
	public List<Movie> searchMovieByGenre(Genre genre) {
		return DataCache.MOVIES.stream().filter(movie -> movie.genre.equals(genre)).collect(Collectors.toList());
	}
	public List<Movie> searchMovieByLanguage(String language) {
		return DataCache.MOVIES.stream().filter(movie -> movie.language.equals(language)).collect(Collectors.toList());
	}
	public List<Movie> searchMovieByDate(LocalDate releaseDate) {
		return DataCache.MOVIES.stream().filter(movie -> movie.releaseDate.equals(releaseDate)).collect(Collectors.toList());
	}
}
