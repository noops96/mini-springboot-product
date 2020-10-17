package com.example.Product.Controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Product.Entity.Product;
import com.example.Product.Model.Pagination;
import com.example.Product.Service.ProductService;

@RequestMapping({ "product" })
@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping(value = "/get-list")
	public ResponseEntity<?> getAll() {
		List<Product> account = productService.getAll();
		return ResponseEntity.ok(account);
	}
	
	@GetMapping(value = "/get-by-id",params = {"id"})
	public ResponseEntity<?> getById(int id) {
		Product account = productService.getById(id);
		return ResponseEntity.ok(account);
	}
	
	@GetMapping(value = "/get-pagination", params = {"page", "limit"})
	public ResponseEntity<?> getPagination(int page,int limit) {
		Pagination account = productService.getPagination(page, limit);
		return ResponseEntity.ok(account);
	}
	
	@PostMapping(value = "/add-product")
	public ResponseEntity<?> add(@RequestBody Product product) {
		try {
			productService.add(product);
			return ResponseEntity.ok("ok");
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PutMapping(value = "/edit-product")
	public ResponseEntity<?> edit(@RequestBody Product product) {
		try {
			productService.edit(product);
			return ResponseEntity.ok("ok");
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		try {
		productService.delete(id);
		return ResponseEntity.ok("ok");
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}