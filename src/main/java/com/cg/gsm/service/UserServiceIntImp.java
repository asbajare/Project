package com.cg.gsm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.gsm.entities.Address;
import com.cg.gsm.entities.Booking;
import com.cg.gsm.entities.User;
import com.cg.gsm.repository.UserDAOInt;

@Service
public class UserServiceIntImp implements UserServiceInt {

	@Autowired
	public UserDAOInt userdaoint;
	
	@Override
	public User add(User bean) {
		return userdaoint.save(bean);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userdaoint.findAll();
	}

	@Override
	public void deleteById(int a) {
		// TODO Auto-generated method stub
		userdaoint.deleteById(a);
		
	}

	@Override
	public User findByPK(int pk) {
		// TODO Auto-generated method stub
		Optional<User> u=userdaoint.findById(pk);
		if(u.isPresent())
		return u.get();
		return null;
	}

	@Override
	public Address updateAdd(int a, Address address) {
		// TODO Auto-generated method stub
		
		Optional<User> u=userdaoint.findById(a);
	    if(u.isPresent()) {
	    	User user=u.get();
	    	if(user.getAddress()!=null) {
	    	address.setId(user.getAddress().getId());
	    	}
	    	user.setAddress(address);
	    	userdaoint.save(user);
	    	return user.getAddress();
		}
	  return null;
	}
	
	@Override
	public User updateUser(int a, String firstName, String lastName, long mobileno, String emailId) {
		  Optional<User> u=userdaoint.findById(a);
	        if(u.isPresent()) {
	           User user=u.get();
	           user.setFirstName(firstName);
               user.setLastName(lastName);
               user.setEmailId(emailId);
               user.setMobileNo(mobileno);
               userdaoint.save(user);
               return user;
	        }
	        return null;
	}
}
