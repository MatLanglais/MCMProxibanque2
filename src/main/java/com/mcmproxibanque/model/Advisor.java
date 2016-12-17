package com.mcmproxibanque.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Advisor extends Employee {
	
	@OneToMany
	Collection<Customer> customers = new ArrayList<>();
	
	public Advisor(){}

	public Collection<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Collection<Customer> customers) {
		this.customers = customers;
	}
	


}
