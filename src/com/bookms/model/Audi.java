package com.bookms.model;

import java.util.List;

public class Audi {
	
	public Audi(int audiId, String audiName, int totalSeats, List<Show> shows) {
		super();
		this.audiId = audiId;
		this.audiName = audiName;
		this.totalSeats = totalSeats;
		this.shows = shows;
	}
	public int audiId;
	public String audiName;
	public int totalSeats;
	public List<Show> shows;
	@Override
	public String toString() {
		return "Audi [audiId=" + audiId + ", audiName=" + audiName + ", totalSeats=" + totalSeats + ", shows=" + shows
				+ "]";
	}
	
}
