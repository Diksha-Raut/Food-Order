package com.dk.entity;

//Order.java - Java Bean for Order
import java.sql.Timestamp;
import java.util.List;

public class Order {
 private int id;
 private int userId;
 private Timestamp orderDate;
 private double totalAmount;
 
 private List<OrderDetail> orderDetails;

 // Constructor, getters, and setters

 public List<OrderDetail> getOrderDetails() {
     return orderDetails;
 }

 public void setOrderDetails(List<OrderDetail> orderDetails) {
     this.orderDetails = orderDetails;
 }

 public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public Timestamp getOrderDate() {
	return orderDate;
}
public void setOrderDate(Timestamp orderDate) {
	this.orderDate = orderDate;
}
public double getTotalAmount() {
	return totalAmount;
}
public void setTotalAmount(double totalAmount) {
	this.totalAmount = totalAmount;
}
public Order(int id, int userId, Timestamp orderDate, double totalAmount) {
	super();
	this.id = id;
	this.userId = userId;
	this.orderDate = orderDate;
	this.totalAmount = totalAmount;
}
public Order() {
	super();
	// TODO Auto-generated constructor stub
}

 
 
}
