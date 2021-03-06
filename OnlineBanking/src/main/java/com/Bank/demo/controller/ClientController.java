package com.Bank.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.Bank.demo.Utilies.JsonUtilies;
import com.Bank.demo.model.Client;
import com.Bank.demo.service.ClientService;

@Controller
@RequestMapping(value="/clients")
public class ClientController {
	
	private static Logger logger=LoggerFactory.getLogger(AccountController.class);

	@Autowired
	private ClientService clientService;
	@Autowired
	private JsonUtilies jsonUtilies;
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody String clientStr){
		try {
			Client client=jsonUtilies.getClientObject(clientStr);
			clientService.saveClient(client);
			logger.debug(client.toString());
			return new ResponseEntity<>(HttpStatus.CREATED);

		}catch(Exception e) {
			logger.debug("saveUser \t", e);
			return new ResponseEntity<>(e.toString(),HttpStatus.BAD_REQUEST);
			
		}
		
	}
	
	@DeleteMapping(value="/delete")
	public ResponseEntity<?> deleteClientByMail(@RequestBody String email){	
		try {
					
			String strEmail=jsonUtilies.getUserEmail(email);
		clientService.deleteClientByEmail(strEmail);
		return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			logger.debug("deleteClientByMail \t", e);
			return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/getByClientName",method=RequestMethod.GET)
	public ResponseEntity<?> getClientByName(@RequestParam("clientName") String name){
		try {
		Client client=clientService.getClientByUserName(name);
		if(client!=null)
			return new ResponseEntity<>(client,HttpStatus.OK);
		else
			logger.debug("client is null");
			return new ResponseEntity<>("client is null ",HttpStatus.BAD_REQUEST);
		}catch(Exception e) {
			logger.debug("getClientByName \t", e);
			return new ResponseEntity<>(e.toString(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/getByEmail",method=RequestMethod.GET)
	public ResponseEntity<?> getClientByEmail(@RequestParam("email") String email){
		try {
		Client client=clientService.getClientByEmail(email);
		if(client!=null)
			return new ResponseEntity<>(client,HttpStatus.OK);
		else
			logger.debug("client is null");
			return new ResponseEntity<>("client is null ",HttpStatus.BAD_REQUEST);
		}catch(Exception e) {
			logger.debug("getClientByEmail \t", e);
			return new ResponseEntity<>(e.toString(),HttpStatus.BAD_REQUEST);
		}
	}
}
