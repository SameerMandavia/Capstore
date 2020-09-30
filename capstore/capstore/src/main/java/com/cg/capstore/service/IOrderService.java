package com.cg.capstore.service;

import java.util.List;

import com.cg.capstore.dto.Order;

public interface IOrderService {

	Order addOrder(Order order);
	
	List<Order> getAllOrders();
	
	List<Order> getAllOrdersByUserId(int userId);
	
	
}
