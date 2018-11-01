package com.Bank.demo.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Bank.demo.model.Bank;

@Repository
@Transactional
public interface BankDao extends CrudRepository<Bank, Long> {

	public Bank findBankByName(String bankName);
	
	public Integer deleteByName(String name);

}
