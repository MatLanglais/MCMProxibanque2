package com.mcmproxibanque.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Manager extends Employee{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@OneToMany(cascade={CascadeType.ALL})
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
