package com.cg.gsm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.gsm.entities.Booking;
import com.cg.gsm.entities.BookingProduct;
import com.cg.gsm.entities.User;
import com.cg.gsm.repository.BookingDAOInt;
import com.cg.gsm.repository.BookingProductDAOInt;
import com.cg.gsm.repository.UserDAOInt;

@Service
public class BookingProductServiceIntImp implements BookingProductServiceInt {

	@Autowired
	private BookingProductDAOInt bookingproductdaoint;
	
	@Autowired
	private BookingDAOInt bookingdaoint;
	
	@Autowired
	private UserDAOInt userdaoint;


	@Override
	public List<BookingProduct> getUserBooking() 
	{
		
		List<BookingProduct> listofbp=bookingproductdaoint.findAll();
		return listofbp;
	}
	
	


	


}
