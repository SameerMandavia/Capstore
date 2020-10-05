package com.cg.capstore.service;

import java.util.List;

import com.cg.capstore.dto.ProductItem;

public interface IProductService {
	
	ProductItem addProduct(ProductItem product);
	
	List<ProductItem> getAllProducts();
	
	ProductItem getProductById(int productId);
	
	ProductItem getProductByProductName(String productName);
	
	ProductItem updateProduct(ProductItem product);
	
	String removeProduct(String productName);
	
	String removeProductByProductType(String productType);
	
	String removeProductByProductId(int productId);
	
}
