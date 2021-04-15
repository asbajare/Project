package com.cg.gsm.service;

import java.util.List;
import com.cg.gsm.entities.Address;
import com.cg.gsm.entities.Booking;
import com.cg.gsm.entities.BookingProduct;
import com.cg.gsm.entities.User;

public interface UserServiceInt {

	public User add(User bean); //throws DuplicateRecordException;

	public List<User> findAll();

	public void deleteById(int a);
	
	public User findByPK(int a);

	public Address updateAdd(int a, Address address);

	public User updateUser(int a, String firstName, String lastName, long mobileno, String emailId);

//	public List<User> search(User bean);
//	
//	public List search(User bean, int pageNo, int pageSize) ;
//	 
//    
//
}
