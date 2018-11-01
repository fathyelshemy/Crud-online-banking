package com.Bank.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.Bank.demo.model.enums.TransactionType;

@Entity(name="transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="transaction_id")
	private Long id;
	@NotNull
	@Column(name="transaction_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date transactionDate;
	@Enumerated(EnumType.STRING)
	@Column(name="transaction_type")
	private TransactionType transactionType;
	@NotNull
	@Column(name="transaction_amount")
	private double amount;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="employee_id",nullable=false)
	private Employee employeeId;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="client_id",nullable=false)
	private Client clientId;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="bank_id",nullable=false)
	private Bank bankId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Employee getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Employee employeeId) {
		this.employeeId = employeeId;
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
	public TransactionType getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
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
		Transaction other = (Transaction) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", TransactionDate=" + transactionDate + ", transactionType=" + transactionType
				+ ", amount=" + amount + ", employeeId=" + employeeId + ", clientId=" + clientId + ", bankId=" + bankId
				+ "]";
	}
	
	

}
