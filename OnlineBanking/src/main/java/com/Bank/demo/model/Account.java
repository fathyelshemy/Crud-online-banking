package com.Bank.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity(name="account")
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="account_id")
	private Long id;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="client_id",nullable=false)
	private Client clientId;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="bank_id",nullable=false)
	private Bank bankId;
	
	@NotNull
	@Column(name="balance")
	private double balance;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Client getClientId() {
		return clientId;
	}
	public void setClientId(Client clientId) {
		this.clientId = clientId;
	}
	public Bank getBankId() {
		return bankId;
	}
	public void setBankId(Bank bankId) {
		this.bankId = bankId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", clientId=" + clientId + ", bankId=" + bankId + ", totalAmount=" + balance
				+ "]";
	}
	
	
}
