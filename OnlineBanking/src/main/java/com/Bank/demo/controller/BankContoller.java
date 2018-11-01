package com.Bank.demo.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Bank.demo.Utilies.JsonUtilies;
import com.Bank.demo.model.Bank;
import com.Bank.demo.service.BankService;

@Controller(value="/bank")
public class BankContoller {
	
	private static Logger logger= Logger.getLogger(BankContoller.class);
	
	@Autowired
	private JsonUtilies jsonUtilies;
	
	@Autowired
	private BankService bankService;

	@GetMapping(value="/get",consumes="application/json")
	@ResponseBody
	public ResponseEntity<?> getBankByName(@RequestParam String bankName){
		try {
			Bank bank=bankService.getBankByName(bankName);
			return new ResponseEntity<>(bank,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}	
	}
	
	@DeleteMapping(value="/delete",consumes="application/json")
	@ResponseBody
	public ResponseEntity<?> deleteBankByName(String bankNameStr){
		try {
			String bankName=jsonUtilies.getName(bankNameStr);
			bankService.deleteBankByName(bankName);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value="/save",consumes="application/json")
	@ResponseBody
	public ResponseEntity<?> saveBank(String bankStr){
		try {
			Bank bank=jsonUtilies.getBankObject(bankStr);
			bankService.saveBank(bank);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
