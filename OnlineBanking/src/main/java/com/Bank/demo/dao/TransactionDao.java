package com.Bank.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Bank.demo.model.Transaction;

@Repository
@Transactional
public interface TransactionDao extends CrudRepository<Transaction, Long> {

	public List<Transaction> findTransactionByAmount(double amount);
	
	public List<Transaction> findTransactionByTransactionType(String transactionType);
	
}
