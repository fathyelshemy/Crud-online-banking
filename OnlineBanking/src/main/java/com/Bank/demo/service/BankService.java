package com.Bank.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bank.demo.dao.BankDao;
import com.Bank.demo.model.Bank;

@Service
public class BankService {
	
	@Autowired
	private BankDao bankDao;
	
	public void saveBank(Bank bank) {
		bankDao.save(bank);
	}
	
	public Bank getBankByName(String bankName) {
		Bank bank= bankDao.findBankByName(bankName);
		return bank;
	}
	
	public Integer deleteBankByName(String bankName) {
		return bankDao.deleteByName(bankName);
	}
	
	
}
