package com.Bank.demo.Utilies;

import java.util.Date;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Bank.demo.model.Account;
import com.Bank.demo.model.Address;
import com.Bank.demo.model.Bank;
import com.Bank.demo.model.Client;
import com.Bank.demo.model.Employee;
import com.Bank.demo.model.Transaction;
import com.Bank.demo.model.enums.TransactionType;


@Component
public class JsonUtilies {
	
	@Autowired
	private EncryptionUtilies encryptedUtilies;
	
	public Client getClientObject(String clientStr) {
		JSONObject jsonUser=new JSONObject(clientStr);
		Client user= new Client();
		if(jsonUser.isNull("clientId")) {
			user.setId(null);
		}else {
			user.setId(Long.valueOf(jsonUser.getString("clientId")));
		}
		if(jsonUser.isNull("clientName")) {
			user.setClientName(null);
		}else {
			user.setClientName(jsonUser.getString("clientName"));
		}
		if(jsonUser.isNull("password")) {
			user.setPassword(null);
		}else {
			String encryptedPassword=encryptedUtilies.getSHA_512EncryptedPassword(jsonUser.getString("password"));
			user.setPassword(encryptedPassword);
		}
		if(jsonUser.isNull("email")) {
			user.setEmail(null);
		}else {
			user.setEmail(jsonUser.getString("email"));
		}
		if(jsonUser.isNull("address")) {
			user.setUserAddress(null);
		}else {
			user.setUserAddress(getAddressObject(jsonUser.get("address").toString()));
		}
		return user;
	}
	
	public Employee getEmployeeObject(String employeeStr) {
		JSONObject jsonUser=new JSONObject(employeeStr);
		Employee employee= new Employee();
		if(jsonUser.isNull("employeeId")) {
			employee.setId(null);
		}else {
			employee.setId(Long.valueOf(jsonUser.getString("employeeId")));
		}
		if(jsonUser.isNull("employeeName")) {
			employee.setUserName(null);
		}else {
			employee.setUserName(jsonUser.getString("employeeName"));
		}
		if(jsonUser.isNull("password")) {
			employee.setPassword(null);
		}else {
			employee.setPassword(jsonUser.getString("password"));
		}
		if(jsonUser.isNull("email")) {
			employee.setEmail(null);
		}else {
			employee.setEmail(jsonUser.getString("email"));
		}
		if(jsonUser.isNull("address")) {
			employee.setUserAddress(null);
		}else {
			employee.setUserAddress(getAddressObject(jsonUser.getString("address")));
		}
		return employee;
	}

	public Bank getBankObject(String bankStr) {
		JSONObject bankJson= new JSONObject(bankStr);
		Bank bank= new Bank();
		if(bankJson.isNull("bankId")){
			bank.setId(null);
		}else {
			bank.setId(Long.valueOf(bankJson.getString("bankId")));
		}
		if(bankJson.isNull("bankName")){
			bank.setName(null);
		}else {
			bank.setName(bankJson.getString("bankName"));
		}
		if(bankJson.isNull("mobileNumber")) {
			bank.setMobileNumber(null);
		}else {
			bank.setMobileNumber(bankJson.getString("mobileNumber"));
		}
		if(bankJson.isNull("address")) {
			bank.setAddress(null);
		}else {
			bank.setAddress(getAddressObject(bankJson.getString("address")));
		}
		
		return bank;
	}

	public Account getAccountObject(String accountstr) {
		JSONObject accountJson= new JSONObject(accountstr);
		Account account= new Account();
		if(accountJson.isNull("accountId")) {
			account.setId(null);
		}else {
			account.setId(Long.valueOf((accountJson.getString("accountId"))));
		}
		if(accountJson.isNull("clientId")) {
			account.setClientId(null);
		}else {
			account.setClientId(getClientObject(accountJson.getString("clientId")));
		}
		if(accountJson.isNull("bankId")) {
			account.setBankId(null);
		}else {
			account.setBankId(getBankObject(accountJson.getString("bankId")));
		}
		if(accountJson.isNull("balance")) {
			account.setBalance(0);
		}else {
			account.setBalance(accountJson.getDouble("balance"));
		}
		return account;
	}
	
	public Address getAddressObject(String addressStr) {
		JSONObject addressJson= new JSONObject(addressStr);
		Address address= new Address();
		if(addressJson.isNull("country")) {
			address.setCountry(null);
		}else {
			address.setCountry(addressJson.getString("country"));
		}
		if(addressJson.isNull("governate")) {
			address.setGovernate(null);
		}else {
			address.setGovernate(addressJson.getString("governate"));
		}
		if(addressJson.isNull("district")) {
			address.setDistrict(null);
		}else {
			address.setDistrict(addressJson.getString("district"));
		}
		if(addressJson.isNull("city")) {
			address.setCity(null);
		}else {
			address.setCity(addressJson.getString("city"));
		}
		if(addressJson.isNull("street")) {
			address.setStreet(null);
		}else {
			address.setStreet(addressJson.getString("street"));
		}
		if(addressJson.isNull("buildingNumber")) {
			address.setBuildingNumber(null);
		}else {
			address.setBuildingNumber(addressJson.getString("buildingNumber"));
		}
		if(addressJson.isNull("zipCode")) {
			address.setZipCode(null);
		}else {
			address.setZipCode(addressJson.getString("zipCode"));
		}
		
		return address;
	}
	
	public Transaction getTransactionObject(String transactionStr) {
		JSONObject transactionJson= new JSONObject(transactionStr);
		Transaction transaction = new Transaction();
		
		if(transactionJson.isNull("transactionId")) {
			transaction.setAmount(0);
		}else {
			transaction.setId(Long.valueOf(transactionJson.getString("transactionId")));
		}
		
		if(transactionJson.isNull("transactionDate")) {
			transaction.setTransactionDate(null);
		}else {
			transaction.setTransactionDate(new Date(transactionJson.getString("transactionDate")));
		}
		if(transactionJson.isNull("transactionType")) {
			transaction.setTransactionType(null);
		}else {
			transaction.setTransactionType(TransactionType.valueOf(transactionJson.getString("transactionType")));
		}		
		if(transactionJson.isNull("amount")) {
			transaction.setAmount(0);
		}else {
			transaction.setAmount(transactionJson.getDouble("amount"));
		}
		if(transactionJson.isNull("employeeId")) {
			transaction.setEmployeeId(null);
		}else {
			transaction.setEmployeeId(getEmployeeObject(transactionJson.getString("employeeId")));
		}
		if(transactionJson.isNull("clientId")) {
			transaction.setClientId(null);
		}else {
			transaction.setClientId(getClientObject(transactionJson.getString("clientId")));
		}
		if(transactionJson.isNull("bankId")) {
			transaction.setBankId(null);
		}else {
			transaction.setBankId(getBankObject(transactionJson.getString("bankId")));
		}
		return transaction;
	}

	
	public String getUserEmail(String email) {
		JSONObject emailJson= new JSONObject(email);
		String emailStr=null;
		if(!(emailJson.isNull("email"))) {
			emailStr=emailJson.getString("email");
		}
		return emailStr;
	}
	
	public String getName(String name) {
		JSONObject nameJson=new JSONObject(name);
		String nameStr=null;
		if(!(nameJson.isNull("name"))) {
			nameStr=nameJson.getString("name");
		}
		return nameStr;
	}

}
