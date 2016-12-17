package com.mcmproxibanque.model;

import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Manager extends Employee {

	@OneToMany
	HashMap<Long, Advisor> advisorsMap = new HashMap<>();
	
	public Manager(){}
	
	// Getters & Setters
	public HashMap<Long, Advisor> getAdvisorsMap() {
		return advisorsMap;
	}

	public void setAdvisorsMap(HashMap<Long, Advisor> advisorsMap) {
		this.advisorsMap = advisorsMap;
	}

}
