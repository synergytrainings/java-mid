package com.synisys.training.map;

public final class User {
	
	private final Integer userId;
	private final String username;
	private final String name;
	private String email;
	
	public User(Integer userId, String username, String name) {
		this.userId = userId;
		this.username = username;
		this.name = name;
	}
	
	public Integer getUserId() {
		return this.userId;
	}
	
	public String getUserName() {
		return this.username;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
}
