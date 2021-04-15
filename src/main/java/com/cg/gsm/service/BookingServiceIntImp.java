package com.cg.gsm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.gsm.entities.Booking;
import com.cg.gsm.entities.BookingProduct;
import com.cg.gsm.entities.Product;
import com.cg.gsm.entities.User;
import com.cg.gsm.exception.OutofStockException;
import com.cg.gsm.exception.ProductNotFoundException;
import com.cg.gsm.repository.BookingDAOInt;
import com.cg.gsm.repository.BookingProductDAOInt;
import com.cg.gsm.repository.UserDAOInt;


@Service
public class BookingServiceIntImp implements BookingServiceInt {

@Autowired
private BookingDAOInt bookdaoint;

@Autowired
private BookingProductDAOInt bookingproductdaoint;
	
@Autowired
private ProductServiceInt productserviceint;

@Autowired
private UserServiceInt userserviceint;

@Autowired
private UserDAOInt userdaoint;

@Override
public void add(int id, String[] code, int[] quantity) throws ProductNotFoundException, OutofStockException{

	Booking booking=new Booking();
	List<BookingProduct> listbp=new ArrayList();
	Product p=null;
	double amount=0;
	for(int i=0;i<quantity.length;i++) {
	p=productserviceint.findByCode(code[i]);
	if(p==null)
	throw new ProductNotFoundException("Product with code = "+code[i]+" Not Found");
	if(p.getQuantityInStock()<quantity[i]) {
	throw new OutofStockException("Product with code = "+code[i]+" is Out of Stock..Cannot Book Product!!!!");
	}
	amount=amount+p.getPrice()*quantity[i];
	BookingProduct bp=new BookingProduct();
	bp.setProduct(p);
    p.setQuantityInStock(p.getQuantityInStock()-quantity[i]);	
	bp.setQuantity(quantity[i]);
	bp.setBooking(booking);
	listbp.add(bp);
	}
	booking.setAmount(amount);
	booking.setBookingproducts(listbp);
	booking.setUser(userserviceint.findByPK(id));
	bookdaoint.save(booking);
}

@Override
public List<Booking> getUserBookingByID(int a) {
	User u = userdaoint.findById(a).get();
	List<Booking> b = u.getBookings();
	return b;
}
}
