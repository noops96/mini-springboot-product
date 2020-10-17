package com.example.Product.Entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "seller_id")
	private Integer sellerId;
	
	@Column(name = "price")
	private BigDecimal price;
	
	@JoinColumn(name = "product_type_id", referencedColumnName = "id")
	@OneToOne
	private ProductType ProductType;

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSellerId() {
		return sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public ProductType getProductType() {
		return ProductType;
	}

	public void setProductType(ProductType productType) {
		ProductType = productType;
	}
}