package com.bookms.model;

import java.time.LocalDate;
import java.util.List;

import com.bookms.enumeration.BookingStatus;

public class Booking {
	public int bookingId;
	public LocalDate bookingDate;
	public Member member;
	public Show show;
	public Audi audi;
	public BookingStatus bookingStatus;
	public double amount;
	public List<Seat> seats;
	public Payment paymentObj;

    boolean makePayment(Payment payment) {
    	return false;
    }
}
