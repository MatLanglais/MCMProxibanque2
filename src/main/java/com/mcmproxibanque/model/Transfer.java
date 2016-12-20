package com.mcmproxibanque.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transfer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;

	String date;
	Long fromAccount;
	Long toAccount;
	double amount;
	
	// Constructors
	public Transfer() {
	}

	// Getters & Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Long getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(Long fromAccount) {
		this.fromAccount = fromAccount;
	}

	public Long getToAccount() {
		return toAccount;
	}

	public void setToAccount(Long toAccount) {
		this.toAccount = toAccount;
	}

	@Override
	public String toString() {
		return "Transfer [id=" + id + ", date=" + date + ", fromAccount=" + fromAccount + ", toAccount=" + toAccount
				+ ", amount=" + amount + "]";
	}

}
