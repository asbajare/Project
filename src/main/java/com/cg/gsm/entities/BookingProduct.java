package com.cg.gsm.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="booking_products")
@IdClass(BookingProductId.class)
public class BookingProduct{
	
	@Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_code", referencedColumnName = "code")
    private Product product;
	
	
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "booking_id", referencedColumnName = "id")
    private Booking booking;
    
    @JoinColumn(name = "quantity")
    private int quantity;

	public Product getProduct() {
		return product;
	}

	public Booking getBooking() {
		return booking;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
    
    
}
