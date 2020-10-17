package com.example.Product.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.Product.Entity.ProductType;
@Transactional 
@Repository
public class ProductTypeDAO extends BaseDAO<ProductType> {
	
	@PersistenceContext
	private EntityManager manager;
	 
	public ProductTypeDAO(){
		setClazz(ProductType.class,"product_type");
	}

}
