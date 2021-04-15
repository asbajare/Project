package com.cg.gsm.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Product {
@Id
private String code;
private String name;
private double price;
private String description;
private int quantityInStock;
private String category;

public Product() {
	super();
	// TODO Auto-generated constructor stub
}

public String getCode() {
	return code;
}

public String getName() {
	return name;
}

public double getPrice() {
	return price;
}

public String getDescription() {
	return description;
}
public int getQuantityInStock() {
	return quantityInStock;
}
public String getCategory() {
	return category;
}

public void setCode(String code) {
	this.code = code;
}
public void setName(String name) {
	this.name = name;
}
public void setPrice(double price) {
	this.price = price;
}
public void setDescription(String description) {
	this.description = description;
}




public void setQuantityInStock(int quantityInStock) {
	this.quantityInStock = quantityInStock;
}


public void setCategory(String category) {
	this.category = category;
}


public List<BookingProduct> getBookingproducts() {
	return bookingproducts;
}

public void setBookingproducts(List<BookingProduct> bookingproducts) {
	this.bookingproducts = bookingproducts;
}

@JsonIgnore
@OneToMany(mappedBy = "booking",fetch = FetchType.EAGER)
private List<BookingProduct> bookingproducts;
}
