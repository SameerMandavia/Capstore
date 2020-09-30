package com.cg.capstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.capstore.dto.Transaction;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

}
