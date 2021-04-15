package com.cg.gsm.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Booking{
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
@Temporal(value = TemporalType.DATE)
@JsonFormat(pattern = "yyyy-MM-dd")
private Date date;
private double amount;



public int getId() {
	return id;
}

public Date getDate() {
	return date;
}

public double getAmount() {
	return amount;
}

public void setId(int id) {
	this.id = id;
}

public void setDate(Date date) {
	this.date = date;
}

public void setAmount(double amount) {
	this.amount = amount;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public List<BookingProduct> getBookingproducts() {
	return bookingproducts;
}

public void setBookingproducts(List<BookingProduct> bookingproducts) {
	this.bookingproducts = bookingproducts;
}

@JsonIgnore
@OneToMany(mappedBy = "product",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
private List<BookingProduct> bookingproducts;


@ManyToOne(fetch =FetchType.EAGER)
@JoinColumn(name="user_id")
private User user;
}
