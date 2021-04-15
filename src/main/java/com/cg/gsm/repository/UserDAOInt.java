package com.cg.gsm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.gsm.entities.User;

@Repository
public interface UserDAOInt extends JpaRepository<User,Integer>{

//	
//	public void update(User bean);
//	
//	public void delete(User bean);
//	
//	public User findByLogin(String login);
//	
//	public User findByPk(long id);
//	
//	public List<User> search(User bean, long pageNo, int pageSize);
//	
//	public List<User> search(User bean);
//	
//	public User authenticate(User bean);
	
}
