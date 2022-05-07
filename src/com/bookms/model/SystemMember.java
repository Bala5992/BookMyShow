package com.bookms.model;

public class SystemMember extends User {
	public SystemMember(String userName, String password, boolean isAdmin) {
		super(userName, password, isAdmin);
	}
	public String name;
	public String email;
	public Address adress;
}
