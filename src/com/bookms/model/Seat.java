package com.bookms.model;

import com.bookms.enumeration.SeatStatus;
import com.bookms.enumeration.SeatType;

public class Seat {
	public Seat(int seatId, SeatType seatType, SeatStatus seatStatus, double price) {
		super();
		this.seatId = seatId;
		this.seatType = seatType;
		this.seatStatus = seatStatus;
		this.price = price;
	}
	public int seatId;
	public SeatType seatType;
	public SeatStatus seatStatus;
	public double price;
	@Override
	public String toString() {
		return "Seat [seatId=" + seatId + ", seatType=" + seatType + ", seatStatus=" + seatStatus + ", price=" + price
				+ "]";
	}
	
}
