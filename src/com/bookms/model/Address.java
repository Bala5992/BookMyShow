package com.bookms.model;

public class Address {
	
	public Address(String street, String city, int pinCode, String state, String country) {
		super();
		this.street = street;
		this.city = city;
		this.pinCode = pinCode;
		this.state = state;
		this.country = country;
	}
	public String street;
	public String city;
	public int pinCode;
	public String state;
	public String country;
}
