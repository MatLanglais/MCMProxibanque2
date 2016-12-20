package com.mcmproxibanque.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Advisor extends Employee {
	
	@OneToMany(cascade={CascadeType.ALL})
	Collection<Customer> customers = new ArrayList<>();
	
	public Advisor(){}

	public Collection<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Collection<Customer> customers) {
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "Advisor id=" + id + ", login=" + login + ", password=" + password
				+ ", name=" + name + ", forename=" + forename + "]";
	}
	
	


}
