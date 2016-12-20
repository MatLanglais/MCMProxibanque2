package com.mcmproxibanque.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.Hibernate;

@Entity
public class Advisor extends Employee {
	
	@OneToMany(cascade={CascadeType.ALL})
	Collection<Customer> customers = new ArrayList<>();
	
	public Advisor(){}

	public Collection<Customer> getCustomers() {
		Hibernate.initialize(this);
		return customers;
	}

	public void setCustomers(Collection<Customer> customers) {
		this.customers = customers;
	}
	


}
