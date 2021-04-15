package com.cg.gsm.service;

import java.util.List;

import com.cg.gsm.entities.Booking;
import com.cg.gsm.exception.OutofStockException;
import com.cg.gsm.exception.ProductNotFoundException;

public interface BookingServiceInt {
	
	void add(int id, String[] code, int[] quantity) throws ProductNotFoundException, OutofStockException;

	public List<Booking> getUserBookingByID(int a);
	
	//	public long add(Booking bean);
//	
//	public void update(Booking bean);
//	
//	public void delete(Booking bean);
//	
//	public Booking findByName(String name);
//	
//	public Booking findByPk(long id);
//	
//	public List<Booking> search(Booking bean, long pageNo, int pageSize);
//	
//	public List<Booking> search(Booking bean);
	
}
