package com.mcmproxibanque.model;

import javax.persistence.Entity;

@Entity
public class CurrentAccount extends Account {
	
	Double overdraft;
	
	public CurrentAccount(){}

	// Getters & Setters
	public Double getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(Double overdraft) {
		this.overdraft = overdraft;
	}
	
	

}
