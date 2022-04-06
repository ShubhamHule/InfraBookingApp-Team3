package com.zensar.room.bean;

public class LoginUser {

	private String email;
	private String password;

	public LoginUser() {
		super();
	}

	public LoginUser(String userName) {
		super();
		this.email = userName;
	}

	public LoginUser(String userName, String password) {
		super();
		this.email = userName;
		this.password = password;
	}

	public String getUserName() {
		return email;
	}

	public void setUserName(String userName) {
		this.email = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginUser [userName=" + email + ", password=" + password + "]";
	}

}
