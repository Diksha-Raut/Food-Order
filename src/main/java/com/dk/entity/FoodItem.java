package com.dk.entity;

//FoodItem.java - Java Bean for Food Item


public class FoodItem {
 private int id;
 private String name;
 private String description;
 private double price;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public double getPrice() {
	return price;
}
public void setPrice(double d) {
	this.price = d;
}
public FoodItem(int id, String name, String description, double price) {
	super();
	this.id = id;
	this.name = name;
	this.description = description;
	this.price = price;
}
public FoodItem() {
	super();

}
@Override
public String toString() {
	return "FoodItem [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + "]";
}


}
