package com.mcmproxibanque.dto;

import javax.faces.bean.ManagedBean;

import com.mcmproxibanque.model.Customer;

@ManagedBean
public class CustomerController {
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public CustomerController() {
	
	}
}
