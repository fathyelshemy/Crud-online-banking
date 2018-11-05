package com.Bank.demo.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Bank.demo.Utilies.JsonUtilies;
import com.Bank.demo.model.Account;
import com.Bank.demo.service.AccountService;

@Controller
@RequestMapping(value="/account")
public class AccountController {
	
	private static Logger logger=Logger.getLogger(AccountController.class);
	
	@Autowired
	private AccountService accountService;
	@Autowired
	private JsonUtilies jsonUtilies;
	
	@PostMapping(path="/save",consumes="application/json;charset=utf-8")
	@ResponseBody
	public ResponseEntity<?> saveAccount(@RequestBody String accountStr){
		try {
			Account account=jsonUtilies.getAccountObject(accountStr);
			accountService.saveAccount(account);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping(path="/get",produces="application/json;charset=utf-8")
	public ResponseEntity<?> getAccountbyBalance(@RequestParam("balance") String balanceStr){
		try {
			double balance=Double.valueOf(balanceStr);
			Account account=accountService.getAccountByBalance(balance);
			return new ResponseEntity<>(account,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
}
