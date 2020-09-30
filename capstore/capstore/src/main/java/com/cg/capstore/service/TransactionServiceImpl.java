package com.cg.capstore.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.capstore.dto.Transaction;
import com.cg.capstore.repository.TransactionRepository;

@Transactional
@Service
public class TransactionServiceImpl implements ITransactionService{
	
	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public Transaction addTransaction(Transaction transaction) {

		
		transaction.setTransactionTime(LocalDateTime.now());
		return transactionRepository.save(transaction);
	}

}
