package com.mcmproxibanque.model;

import javax.persistence.Entity;

@Entity
public class CurrentAccount extends Account {
	
	double overdraft = 1000;
	
	public CurrentAccount(){}

	// Getters & Setters
	public Double getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(Double overdraft) {
		this.overdraft = overdraft;
	}
	
	

}
