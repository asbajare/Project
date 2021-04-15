package com.cg.gsm.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
public class User{
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private String firstName;
private String lastName;
private long mobileNo;
private String emailId;

@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
@JoinColumn(name="add_id")
private Address address;

@JsonIgnore
@OneToMany(targetEntity=Booking.class,cascade = CascadeType.ALL,fetch =FetchType.EAGER)
@JoinColumn(name="user_id")
public List<Booking> bookings;

public User() {
	super();
	// TODO Auto-generated constructor stub
}

public int getId() {
	return id;
}

public String getFirstName() {
	return firstName;
}

public String getLastName() {
	return lastName;
}

public long getMobileNo() {
	return mobileNo;
}

public String getEmailId() {
	return emailId;
}

public Address getAddress() {
	return address;
}

public void setId(int id) {
	this.id = id;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public void setMobileNo(long mobileNo) {
	this.mobileNo = mobileNo;
}

public void setEmailId(String emailId) {
	this.emailId = emailId;
}

public void setAddress(Address address) {
	this.address = address;
}

public List<Booking> getBookings() {
	return bookings;
}

public void setBookings(List<Booking> bookings) {
	this.bookings = bookings;
}

}
