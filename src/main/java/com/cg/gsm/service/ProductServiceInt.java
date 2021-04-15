package com.cg.gsm.service;

import java.util.List;

import com.cg.gsm.entities.Product;
import com.cg.gsm.entities.User;

public interface ProductServiceInt {

	public Product add(Product bean);
//public long add(Product bean) throws DuplicateRecordException;
//	
//	public void update(Product bean) throws DuplicateRecordException;
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

	public void deleteByCode(String a);

	public Product findByCode(String code);

	public List<Product> findAll();
	
}
