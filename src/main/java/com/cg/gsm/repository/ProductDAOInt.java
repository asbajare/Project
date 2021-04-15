package com.cg.gsm.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.gsm.entities.Product;
import com.cg.gsm.entities.User;



public interface ProductDAOInt extends JpaRepository<Product,String>{

//	public long add(Product bean);
//	
//	public void update(Product bean);
//	
//	public void delete(Product bean);
//	
//	public Product findByName(String name);
//	
//	public Product findByCode(String code);
//	
//	public Product findByPk(long id);
//	
//	public List<Product> search(Product bean, long pageNo, int pageSize);
//	
//	public List<Product> search(Product bean);
//	
//	public Blob getImageById(long id) throws SerialException, SQLException;
	
}
