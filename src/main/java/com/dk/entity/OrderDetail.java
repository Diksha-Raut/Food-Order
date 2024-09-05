package com.dk.entity;

//OrderDetail.java - Java Bean for Order Detail
import java.math.BigDecimal;

public class OrderDetail {
 private int id;
 private int orderId;
 private int foodItemId;
 private int quantity;
 private double price;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getOrderId() {
	return orderId;
}
public void setOrderId(int orderId) {
	this.orderId = orderId;
}
public int getFoodItemId() {
	return foodItemId;
}
public void setFoodItemId(int foodItemId) {
	this.foodItemId = foodItemId;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public OrderDetail(int id, int orderId, int foodItemId, int quantity, double price) {
	super();
	this.id = id;
	this.orderId = orderId;
	this.foodItemId = foodItemId;
	this.quantity = quantity;
	this.price = price;
}
public OrderDetail() {
	super();
	// TODO Auto-generated constructor stub
}


}
