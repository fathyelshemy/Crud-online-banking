package com.Bank.demo.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Bank.demo.Utilies.JsonUtilies;
import com.Bank.demo.model.Employee;
import com.Bank.demo.service.EmployeeService;

@Controller(value="/employee")
public class EmployeeController {

	private static Logger logger=Logger.getLogger(EmployeeController.class);
	
	@Autowired
	private JsonUtilies jsonUtilies;
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping(value="/save",consumes="application/json")
	@ResponseBody
	public ResponseEntity<?> saveEmployee(@RequestBody String employeeStr){
		try {
			Employee employee=jsonUtilies.getEmployeeObject(employeeStr);
			employeeService.saveEmployee(employee);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}catch(Exception e) {
			logger.debug(e.toString());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@DeleteMapping(value="/delete",consumes="application/json")
	@ResponseBody
	public ResponseEntity<?> deleteEmployeeByMail(@RequestBody String emailStr){
		try {
			String email=jsonUtilies.getUserEmail(emailStr);
			employeeService.deleteClientByEmail(email);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			logger.debug(e.toString());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping(value="/get",consumes="application/json")
	@ResponseBody
	public ResponseEntity<?> getEmployeeByMail(@RequestParam("email") String emailStr){
		try {
			String email=jsonUtilies.getUserEmail(emailStr);
			Employee employee=employeeService.getEmployeeByMail(email);
			return new ResponseEntity<>(employee,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
