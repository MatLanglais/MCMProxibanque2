package com.mcmproxibanque.model;

import javax.persistence.Entity;

@Entity
public class SavingAccount extends Account {

	double rate = 0.3;
	
	public SavingAccount(){}

	// Getters & Setters
	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

}
