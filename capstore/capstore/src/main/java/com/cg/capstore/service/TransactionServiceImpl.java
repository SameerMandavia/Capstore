package com.cg.capstore.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.capstore.dto.Transaction;
import com.cg.capstore.repository.TransactionRepository;

@Transactional
@Service
public class TransactionServiceImpl implements ITransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private MailServiceImpl mailService;

	@Override
	public Transaction addTransaction(Transaction transaction) {

		LocalDateTime datetime = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formatDateTime = datetime.format(format);

		transaction.setTransactionTime(LocalDateTime.now());
//		mailService.sendMail(
//				transaction.getUser().getEmailId(), "Successfully ordered "
//				+ transaction.getOrder().getCart().getProductName() +" "+" in only Rs."+transaction.getOrder().getCart().getAmount()
//				+" on " 
//				+ formatDateTime + ".",
//				transaction.getOrder().getCart().getProductName() + " Product successfully ordered.");
		
		mailService.sendMail(transaction.getUser().getEmailId(),
		"Hello "+transaction.getUser().getUserName()+",\n"+" You have ordered "+transaction.getOrder().getTotalQuantity()+" "+transaction.getOrder().getCart().getProductName()+" order and Total Amount are Rs."+transaction.getOrder().getTotalAmount(),
		transaction.getOrder().getCart().getProductName() + " Product successfully ordered.");
		
		return transactionRepository.save(transaction);
	}

}
