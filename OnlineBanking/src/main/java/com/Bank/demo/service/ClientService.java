package com.Bank.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bank.demo.dao.ClientDao;
import com.Bank.demo.model.Client;

@Service
public class ClientService {

	@Autowired
	private ClientDao clientRepo;
	
	public void saveClient(Client client) {
		clientRepo.save(client);
	}
	
	public void deleteClientByEmail(String email) {
		clientRepo.deleteByEmail(email);
	}
	
	public List<Client> getAllClients(){
		return (List<Client>) clientRepo.findAll();
	}
	
	public Client getClientByUserName(String userName) {
		return clientRepo.findClientByClientName(userName);
	}
	
	public Client getClientByEmail(String email) {
		return clientRepo.findClientByEmail(email);
	}
	
	public void deleteClient(Client client) {
		clientRepo.delete(client);
	}
}
