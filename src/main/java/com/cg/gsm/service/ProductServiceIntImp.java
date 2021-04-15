package com.cg.gsm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.gsm.entities.Product;
import com.cg.gsm.repository.ProductDAOInt;

@Service
public class ProductServiceIntImp implements ProductServiceInt {
	
	@Autowired
	private ProductDAOInt productdaoint;

	@Override
	public Product add(Product bean) {
		return productdaoint.save(bean);
	}

	@Override
	public void deleteByCode(String a) {
		// TODO Auto-generated method stub
		productdaoint.deleteById(a);
	}

	@Override
	public Product findByCode(String code) {
		// TODO Auto-generated method stub
		Optional<Product> u=productdaoint.findById(code);
		if(u.isPresent())
		return u.get();
		return null;
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productdaoint.findAll();
	}

	@Override
	public Product updateProduct(String code, String name, double price, String description, int quantityinStock,
			String category) {
		// TODO Auto-generated method stub
		  Optional<Product> p=productdaoint.findById(code);
		  if(p.isPresent()) {
	           Product product=p.get();
	           product.setCategory(category);
	           product.setCode(code);
	           product.setDescription(description);
	           product.setName(name);
	           product.setPrice(price);
	           product.setQuantityInStock(quantityinStock);
               productdaoint.save(product);
              return product;
	        }
	        return null;
	}
	
}
