package com.bookms.model;

public class User {
	
	public User(String userName, String password, boolean isAdmin) {
		super();
		this.userName = userName;
		this.password = password;
		this.isAdmin = isAdmin;
		this.searchObj = new Search();
	}
	public String userName;
	public String password;
	public Search searchObj;
	public boolean isAdmin;
}
