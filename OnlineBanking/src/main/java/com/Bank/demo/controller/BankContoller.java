package com.Bank.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Bank.demo.Utilies.JsonUtilies;
import com.Bank.demo.model.Bank;
import com.Bank.demo.service.BankService;

@Controller
@RequestMapping(value="/bank")
public class BankContoller {
	
	private static Logger logger=LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	private JsonUtilies jsonUtilies;
	
	@Autowired
	private BankService bankService;

	@GetMapping(path="/get",produces="application/json;charset=utf-8")
	@ResponseBody
	public ResponseEntity<?> getBankByName(@RequestParam("bankName") String bankName){
		try {
			Bank bank=bankService.getBankByName(bankName);
			return new ResponseEntity<>(bank,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}	
	}
	
	@DeleteMapping(path="/delete",consumes="application/json;charset=utf-8")
	@ResponseBody
	public ResponseEntity<?> deleteBankByName(@RequestBody String bankNameStr){
		try {
			String bankName=jsonUtilies.getName(bankNameStr);
			bankService.deleteBankByName(bankName);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(path="/save",consumes="application/json;charset=utf-8")
	@ResponseBody
	public ResponseEntity<?> saveBank(@RequestBody String bankStr){
		try {
			Bank bank=jsonUtilies.getBankObject(bankStr);
			bankService.saveBank(bank);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
