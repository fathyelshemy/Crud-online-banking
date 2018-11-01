package com.Bank.demo.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Bank.demo.model.Client;

@Repository
@Transactional 
public interface ClientDao extends CrudRepository<Client, Long> {

	@Query("select c.password  from client c where c.email= :email")
	public String getPasswordByEmail(String email);
	
	@Query("select c.password from client c where c.clientName= :clientName")
	public String getPasswordByClientName(String clientName);
	
	public Client findClientByClientName(String userName);
	
	public Client findClientByEmail(String email);
		
	public Integer deleteByEmail(String email);
	
	
	
}
