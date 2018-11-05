package com.Bank.demo.controller;

import java.util.List;

import javax.annotation.PostConstruct;

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
import com.Bank.demo.model.Transaction;
import com.Bank.demo.service.TransactionService;

@Controller
@RequestMapping(value="/transaction")
public class TransactionController {
	
	private static Logger logger=Logger.getLogger(TransactionController.class);
	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private JsonUtilies jsonUtilies;
	
	@PostMapping(path="/save",consumes="application/json;charset=utf-8")
	@ResponseBody
	public ResponseEntity<?> saveTransaction(@RequestBody String transactionStr){
		try {
			Transaction transaction=jsonUtilies.getTransactionObject(transactionStr);
			transactionService.saveTransaction(transaction);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}catch(Exception e) {
			logger.debug(e.toString());
			return new ResponseEntity<>(e.toString(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(path="/getBytransactionsAmount",produces="application/json;charset=utf-8")
	@ResponseBody
	public ResponseEntity<?>getTransactionByAmount(@RequestParam("amount") String amountStr){
		try {
			Double amount=Double.valueOf(amountStr);
			List<Transaction> transactions= transactionService.getTransactionByAmount(amount);
			logger.info(transactions);
			return new ResponseEntity<>(transactions,HttpStatus.OK);
		}catch(Exception e) {
			logger.debug(e.toString());
			return new ResponseEntity<>(e.toString(),HttpStatus.BAD_REQUEST);

		}
	}
	
	@GetMapping(path="/transactionsType",produces="application/json;charset=utf-8")
	@ResponseBody
	public ResponseEntity<?> getTransactionByType(@RequestParam("type") String transactionType){
		try {
			List<Transaction>transactions=transactionService.getTranactionByTransactionType(transactionType);
			logger.info(transactions);
			return new ResponseEntity<>(transactions,HttpStatus.OK);
		}catch(Exception e) {
			logger.debug(e.toString());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}

}
