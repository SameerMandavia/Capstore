package com.cg.capstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.capstore.dto.Order;
import com.cg.capstore.service.OrderServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/capstore/order")
public class OrderController {

	@Autowired
	private OrderServiceImpl orderService;

	@PostMapping(value = "/saveOrder")
	public Order addOrder(@RequestBody Order order) {
		return orderService.addOrder(order);
	}

	@GetMapping(value = "/getAllOrders")
	public List<Order> getAllOrders() {
		return orderService.getAllOrders();
	}

	@GetMapping(value = "/getAllOrdersByUserId/{userId}")
	public List<Order> getAllOrdersByUserId(@PathVariable int userId) {
		return orderService.getAllOrdersByUserId(userId);
	}
}
