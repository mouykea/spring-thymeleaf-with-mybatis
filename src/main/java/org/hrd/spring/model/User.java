package org.hrd.spring.model;

public class User {
	private int id;
	private String username;
	private String gender;
	private String email;
	private String phonenumber;
	private String status;
	private String user_hash;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(int id, String username, String gender, String email, String phonenumber, String status,
			String user_hash) {
		this.id = id;
		this.username = username;
		this.gender = gender;
		this.email = email;
		this.phonenumber = phonenumber;
		this.status = status;
		this.user_hash = user_hash;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUser_hash() {
		return user_hash;
	}
	public void setUser_hash(String user_hash) {
		this.user_hash = user_hash;
	}
	
	
	
	
}
