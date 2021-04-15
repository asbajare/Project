package com.cg.gsm.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.gsm.entities.BookingProduct;
import com.cg.gsm.entities.Product;
import com.cg.gsm.entities.User;
import com.cg.gsm.exception.ProductNotFoundException;
import com.cg.gsm.service.BookingProductServiceInt;
import com.cg.gsm.service.ProductServiceInt;
import com.cg.gsm.service.UserServiceInt;

@RestController
public class OwnerResource 
{

	@Autowired
	private UserServiceInt userserviceint;

	@Autowired
	private ProductServiceInt productserviceint;
	
	@Autowired
	public BookingProductServiceInt bookingproductserviceint;
	


@PostMapping(path="/owner/product/add")
public Product createProduct(@RequestBody Product p) 
{
	return productserviceint.add(p);
}

@DeleteMapping(path = "/owner/product/delete/{code}")
public void deleteProduct(@PathVariable("code") String code) throws ProductNotFoundException 
{
	try 
	{
		productserviceint.deleteByCode(code);
    }
	catch(Exception e) 
	{
		 throw new ProductNotFoundException("Product with code= "+code+" Not Found");
	}
}

@PutMapping(path = "/owner/product/update/{code}")
public Product updateProduct(@PathVariable("code") String code,String name,double price,String description,int quantityinStock,String category) throws ProductNotFoundException 
{
	Product product=productserviceint.updateProduct(code,name,price,description,quantityinStock,category);
    if(product==null) 
    {
    	throw new ProductNotFoundException("Product with id= "+code+" Not Found");
    }
    return product;
}

@GetMapping(path = "owner/product/find/{code}")
public Product retrieveUser(@PathVariable("code") String code) throws ProductNotFoundException 
{
	Product product=productserviceint.findByCode(code);
	if(product==null) 
	{
		throw new ProductNotFoundException("Product with code= "+code+" Not Found");
    }
    return product;
}

@GetMapping(path = "/owner/product/findAll")
public ResponseEntity<Object> retreiveAllProducts()
{
	List<Product> list=productserviceint.findAll();
	if(list.isEmpty()) 
	{
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	return new ResponseEntity(list,HttpStatus.OK);
}



@GetMapping(path = "/owner/users")
public ResponseEntity<Object> retreiveAllUsers()
{
	List<User> list=userserviceint.findAll();
	if(list.isEmpty()) 
	{
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	return new ResponseEntity(list,HttpStatus.OK);
}

@GetMapping(path = "/owner/bookings/findAll/")
public List<BookingProduct> retrieveallBooking(){
	return bookingproductserviceint.getUserBooking();
}
}