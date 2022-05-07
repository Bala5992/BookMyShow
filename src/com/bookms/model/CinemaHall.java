package com.bookms.model;

import java.util.List;

public class CinemaHall {
	public CinemaHall(int cinemaHallId, String cinemaHallName, Address adress, List<Audi> audiList) {
		super();
		this.cinemaHallId = cinemaHallId;
		this.cinemaHallName = cinemaHallName;
		this.adress = adress;
		this.audiList = audiList;
	}
	public int cinemaHallId;
	public String cinemaHallName;
	public Address adress;
	public List<Audi> audiList;
	@Override
	public String toString() {
		return "CinemaHall [cinemaHallId=" + cinemaHallId + ", cinemaHallName=" + cinemaHallName + ", adress=" + adress
				+ ", audiList=" + audiList + "]";
	}
	
}
