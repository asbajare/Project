package com.cg.gsm.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class Address{
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
@NotNull
private String street;
@NotNull
private String locality;
@NotNull
private String city;
@NotNull
private int pincode;
@NotNull
private String state;
@NotNull
private String country;
public int getId() {
	return id;
}
public String getStreet() {
	return street;
}
public String getLocality() {
	return locality;
}
public String getCity() {
	return city;
}
public int getPincode() {
	return pincode;
}
public String getState() {
	return state;
}
public String getCountry() {
	return country;
}
public void setId(int id) {
	this.id = id;
}
public void setStreet(String street) {
	this.street = street;
}
public void setLocality(String locality) {
	this.locality = locality;
}
public void setCity(String city) {
	this.city = city;
}
public void setPincode(int pincode) {
	this.pincode = pincode;
}
public void setState(String state) {
	this.state = state;
}
public void setCountry(String country) {
	this.country = country;
}
public Address() {
	super();
	// TODO Auto-generated constructor stub
}
}
