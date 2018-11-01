package com.Bank.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bank.demo.dao.AccountDao;
import com.Bank.demo.model.Account;

@Service
public class AccountService {

	@Autowired
	private AccountDao accountDao;
	
	public void saveAccount(Account account) {
		accountDao.save(account);
	}
	
	public Account getAccountByBalance(double balance) {
		Account account=accountDao.findAccountByBalance(balance);
		return account;
	}
	
	
}
