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
import com.cg.gsm.entities.Address;
import com.cg.gsm.entities.Booking;
import com.cg.gsm.entities.Product;
import com.cg.gsm.entities.User;
import com.cg.gsm.exception.UserNotFoundException;
import com.cg.gsm.service.BookingServiceInt;
import com.cg.gsm.service.ProductServiceInt;
import com.cg.gsm.service.UserServiceInt;


@RestController
public class UserResource{

	@Autowired
	private UserServiceInt userserviceint;
	
	@Autowired
	private ProductServiceInt productserviceint;
	
	@Autowired
	public BookingServiceInt bookingserviceint;
	
	@PostMapping(path="/user")
	public User createUser(@RequestBody User user) {
	return userserviceint.add(user);
	}
	
	@DeleteMapping(path = "/user/{id}")
    public void deleteUser(@PathVariable("id") int a) throws UserNotFoundException 
    {
		try {
        userserviceint.deleteById(a);
        }
		catch(Exception e) {
			 throw new UserNotFoundException("User with id= "+a+" Not Found");
		}
    }
    
    @GetMapping(path = "/user/{id}")
    public User retrieveUser(@PathVariable("id") int a) throws UserNotFoundException {
        
    	User user=userserviceint.findByPK(a);
    	 if(user==null) {
         throw new UserNotFoundException("User with id= "+a+" Not Found");
         }
         return user;
    }
   
    @PutMapping(path = "/user/{id}/address")
    public Address updateUserAddress(@PathVariable("id") int a,@RequestBody Address address) throws UserNotFoundException {

    	   Address addupdated=userserviceint.updateAdd(a,address);
           if(addupdated==null) {
           throw new UserNotFoundException("User with id= "+a+" Not Found");
           }
           return addupdated;
    }
    @PutMapping(path = "/user/{id}/user")
    public User updateUser(@PathVariable("id") int a,String firstName,String lastName,long mobileno,String emailId) throws UserNotFoundException {
    	   User userupdated=userserviceint.updateUser(a,firstName,lastName,mobileno,emailId);
           if(userupdated==null) {
           throw new UserNotFoundException("User with id= "+a+" Not Found");
           }
           return userupdated;
    }
    
    @GetMapping(path = "/user/products")
    public ResponseEntity<Object> retreiveAllProducts()
    {
    List<Product> list=productserviceint.findAll();
    if(list.isEmpty()) {
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    return new ResponseEntity(list,HttpStatus.OK);
    }
   
    @PostMapping(path="/user/{id}/booking")
	public void BookProduct(int id,String[] code,int[] quantity) {
    	bookingserviceint.add(id,code,quantity);
    }
}
