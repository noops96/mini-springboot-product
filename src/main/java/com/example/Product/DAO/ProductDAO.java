package com.example.Product.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.Product.Entity.Product;
@Transactional 
@Repository
public class ProductDAO extends BaseDAO<Product> {
	
	@PersistenceContext
	private EntityManager manager;
	 
	public ProductDAO(){
		setClazz(Product.class,"product");
	}

}
