package com.Bank.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bank.demo.dao.TransactionDao;
import com.Bank.demo.model.Transaction;

@Service
public class TransactionService {

	@Autowired
	private TransactionDao transactionDao;
	
	public void saveTransaction(Transaction transaction) {
		transactionDao.save(transaction);
	}
	
	public List<Transaction> getTransactionByAmount(double amount) {
		List<Transaction> transactions=transactionDao.findTransactionByAmount(amount);
		return transactions;
	}
	
	public List<Transaction> getTranactionByTransactionType(String transactionType){
		List<Transaction> transactions=transactionDao.findTransactionByTransactionType(transactionType);
		return transactions;
	}
	
}
