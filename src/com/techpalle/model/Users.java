package com.techpalle.model;

public class Users
{ 
	private String name;
	private String email;
	private String password;
	private String state;
	
	public Users(String name, String email, String password, String state) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.state = state;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}	
}
