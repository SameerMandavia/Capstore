package com.cg.capstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.capstore.dto.ProductItem;
import com.cg.capstore.service.ProductServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/capstore/product")
public class ProductController {
	
	@Autowired
	private ProductServiceImpl productService;
	
	@PostMapping(value="/addProduct")
	public ProductItem addProduct(@RequestBody ProductItem product) {
		return productService.addProduct(product);
	}

	@GetMapping(value="/getAllProducts")
	public List<ProductItem> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping(value="/getProductById/{productId}")
	public ProductItem getProductById(@PathVariable int productId) {
		return productService.getProductById(productId);
	}

	@GetMapping(value="/getProductByProductName/{productName}")
	public ProductItem getProductByProductName(@PathVariable String productName) {
		return productService.getProductByProductName(productName);
	}

	@PutMapping(value="/updateProduct")
	public ProductItem updateProduct(@RequestBody ProductItem product) {
		return productService.updateProduct(product);
	}

	@DeleteMapping(value="/removeProduct/{productName}")
	public ProductItem removeProduct(String productName) {
		return productService.removeProduct(productName);
	}

}
