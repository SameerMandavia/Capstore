package com.cg.capstore.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.capstore.dto.Transaction;
import com.cg.capstore.repository.TransactionRepository;
import com.cg.capstore.service.TransactionServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/capstore/transaction")
public class TransactionController {
	
	@Autowired
	private TransactionServiceImpl transactionService;
	
	
	@PostMapping(value="/addTransaction") 
	public Transaction addTransaction(@RequestBody Transaction transaction) {

		return transactionService.addTransaction(transaction);
	}

}
