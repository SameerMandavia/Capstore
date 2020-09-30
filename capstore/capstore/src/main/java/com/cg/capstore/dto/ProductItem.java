package com.cg.capstore.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;


@Entity
@Table(name = "productItem")
public class ProductItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "productItemId")
	private int productItemId;

	@Column(name = "productName")
	private String productName;

	@Column(name = "productType")
	@Enumerated(EnumType.STRING)
	private ProductType productType;

	public ProductItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductItem(int productItemId, String productName, ProductType productType, int amount) {
		super();
		this.productItemId = productItemId;
		this.productName = productName;
		this.productType = productType;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "ProductItem [productItemId=" + productItemId + ", productName=" + productName + ", productType="
				+ productType + ", amount=" + amount + "]";
	}

	public int getProductItemId() {
		return productItemId;
	}

	public void setProductItemId(int productItemId) {
		this.productItemId = productItemId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Column(name = "amount")
	private int amount;

//	@ManyToMany(mappedBy = "cart")
//	private Set<Order> orders = new HashSet<Order>();

	
}
