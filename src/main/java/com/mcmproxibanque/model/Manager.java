package com.mcmproxibanque.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Manager extends Employee {

	@OneToMany
	Collection<Advisor> advisors = new ArrayList<>();

	public Manager() {
	}

	// Getters & Setters
	public Collection<Advisor> getAdvisors() {
		return advisors;
	}

	public void setAdvisors(Collection<Advisor> advisors) {
		this.advisors = advisors;
	}

}
