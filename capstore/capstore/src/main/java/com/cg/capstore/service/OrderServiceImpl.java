package com.cg.capstore.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.capstore.dto.Order;
import com.cg.capstore.exception.OrderNotFoundException;
import com.cg.capstore.exception.UserNotFoundException;
import com.cg.capstore.repository.OrderRepository;
import com.cg.capstore.repository.UserRepository;

@Service
@Transactional
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public Order addOrder(Order order) {

		if (order.getUser().getWalletAmount() < order.getTotalAmount()) {
			throw new UserNotFoundException("Not enough money in the account");
		}
		double walletAmount = order.getUser().getWalletAmount() - order.getTotalAmount();
		userRepository.deductWallet(walletAmount, order.getUser().getUserId());

		order.setTime(LocalDateTime.now());
		return orderRepository.save(order);

	}

	@Override
	public List<Order> getAllOrders() {
		List<Order> getAllOrders = orderRepository.findAll();
		if (getAllOrders == null) {
			throw new OrderNotFoundException("Orders not available yet");
		}
		return getAllOrders;
	}

	@Override
	public List<Order> getAllOrdersByUserId(int userId) {

		List<Order> getAllOrdersByUser = orderRepository.getOrdersByUserId(userId);
		if (getAllOrdersByUser == null) {
			throw new OrderNotFoundException("No Products purchased yet");

		}

		return getAllOrdersByUser;
	}

}
