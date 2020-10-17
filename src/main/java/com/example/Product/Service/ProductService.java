package com.example.Product.Service;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Product.DAO.ProductDAO;
import com.example.Product.Entity.Product;
import com.example.Product.Helper.RequestService;
import com.example.Product.Model.Pagination;

@Transactional
@Service
public class ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
	@SuppressWarnings("unchecked")
	public List<Product> getAll() {
		return (List<Product>) productDAO.getAll();
	}
	
	public Product getById(Integer id) {
		return productDAO.getById(id);
	}
	
	public Pagination getPagination(int page , int limit) {
		Pagination pagination = new Pagination();
		pagination.setData(productDAO.getPagination(page, limit));
		pagination.setCount(productDAO.getCount());
		return pagination;
	}
	
	public void add(Product product) throws Exception {
		try {
			if(RequestService.doCheckSeller(product.getSellerId())) {
				product.setId(null);
				product.setCreatedAt(new Timestamp(System.currentTimeMillis()));
				productDAO.add(product);
			}else {
				throw new Exception("seller not Found");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new Exception(e.getLocalizedMessage());
		}
	}
	
	public Product edit(Product product) {
		Product oldProduct = productDAO.getById(product.getId());
		Integer sellerId = oldProduct.getSellerId();
		product.setSellerId(sellerId);
		
		return productDAO.edit(product);
	}
	
	public void delete(Integer id) {
		productDAO.delete(id);
	}

}
