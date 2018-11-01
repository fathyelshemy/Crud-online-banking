package com.Bank.demo.model.enums;

public enum TransactionType {

	Deposite("Deposite"),
	Withdraw("Withdraw");
	
	private String transactionType;
	
	private TransactionType(String transactionType) {
		this.transactionType=transactionType;
	}

	public String getTransactionType() {
		return transactionType;
	}
	

	
}
