package com.mcmproxibanque.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Advisor extends Employee {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@OneToMany(cascade = { CascadeType.ALL })
	Collection<Customer> customers = new ArrayList<>();

	public Advisor() {
	}

	public Collection<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Collection<Customer> customers) {
		this.customers = customers;
	}
}
