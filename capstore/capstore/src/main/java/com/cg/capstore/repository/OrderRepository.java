package com.cg.capstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.capstore.dto.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	@Query("SELECT o FROM Order o JOIN FETCH o.user u WHERE u.userId = :userId")
	List<Order> getOrdersByUserId(int userId);

}
