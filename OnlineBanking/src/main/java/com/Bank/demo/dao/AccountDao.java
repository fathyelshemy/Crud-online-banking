package com.Bank.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Bank.demo.model.Account;

@Repository
public interface AccountDao extends CrudRepository<Account, Long> {

	public Account findAccountByBalance(double balance);
}
