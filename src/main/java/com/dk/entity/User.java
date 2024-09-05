package com.dk.entity;

//User.java - Java Bean for User
public class User {
 private int id;
 private String username;
 private String email;
 private boolean isAdmin;
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public boolean isAdmin() {
	return isAdmin;
}
public void setAdmin(boolean isAdmin) {
	this.isAdmin = isAdmin;
}
@Override
public String toString() {
	return "User [id=" + id + ", username=" + username + ", email=" + email + ", isAdmin=" + isAdmin + "]";
}
public User(int id, String username, String email, boolean isAdmin) {
	super();
	this.id = id;
	this.username = username;
	this.email = email;
	this.isAdmin = isAdmin;
}
public User() {
	super();
	// TODO Auto-generated constructor stub
}


}
