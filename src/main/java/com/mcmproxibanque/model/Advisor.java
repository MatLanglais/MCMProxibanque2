package com.mcmproxibanque.model;

import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Advisor extends Employee {
	
	@OneToMany
	HashMap<Long, Customer> customersMap = new HashMap<>();
	
	public Advisor(){}
	
	// Getters & Setters
	public HashMap<Long, Customer> getCustomersMap() {
		return customersMap;
	}

	public void setCustomersMap(HashMap<Long, Customer> customersMap) {
		this.customersMap = customersMap;
	}

}
