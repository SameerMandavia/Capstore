package com.cg.capstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.capstore.dto.ProductItem;


@Repository
public interface ProductRepository extends JpaRepository<ProductItem, Integer> {

	@Query("SELECT p from ProductItem p WHERE p.productName = :productName")
	ProductItem getProductByName(String productName);
	
}
