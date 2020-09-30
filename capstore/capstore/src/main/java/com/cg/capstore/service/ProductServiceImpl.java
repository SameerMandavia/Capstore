package com.cg.capstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.capstore.dto.ProductItem;
import com.cg.capstore.exception.ProductNotFoundException;
import com.cg.capstore.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements IProductService{

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public ProductItem addProduct(ProductItem product) {

		return productRepository.save(product);
	}

	@Override
	public List<ProductItem> getAllProducts() {

		List<ProductItem> allProducts = productRepository.findAll();
		if(allProducts == null) {
			throw new ProductNotFoundException("No Products available now");
		}
		
		return allProducts;
	}

	@Override
	public ProductItem getProductById(int productId) {

		ProductItem product = productRepository.findById(productId).get();
		if(product == null) {
			throw new ProductNotFoundException("Product not found with given Id- "+productId);
		}
		
		return product;
	}

	@Override
	public ProductItem getProductByProductName(String productName) {
		
		ProductItem getProduct = productRepository.getProductByName(productName);
		if(getProduct == null) {
			throw new ProductNotFoundException("Product not found with given name- "+productName);
		}
		
		return getProduct;
	}

	@Override
	public ProductItem updateProduct(ProductItem product) {

		ProductItem existingProduct = productRepository.findById(product.getProductItemId()).get();
		if(existingProduct == null) {
			throw new ProductNotFoundException("Product not found with given Id- "+product.getProductItemId());
		}
		
		existingProduct.setProductName(product.getProductName());
		existingProduct.setProductType(product.getProductType());
		existingProduct.setAmount(product.getAmount());
		
		return productRepository.save(existingProduct);
	}

	@Override
	public ProductItem removeProduct(String productName) {
		// TODO Auto-generated method stub
		return null;
	}

}
