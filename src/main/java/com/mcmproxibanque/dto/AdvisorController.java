package com.mcmproxibanque.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

import com.mcmproxibanque.model.Advisor;
import com.mcmproxibanque.model.Customer;
import com.mcmproxibanque.service.IService;

@ManagedBean
public class AdvisorController {

	private Advisor advisor;
	//@Autowired
	private IService<Advisor> advisorService;

	public void addCustomer(Customer customer) {
		getAdvisor().getCustomers().add(customer);
		try {
			advisorService.merge(getAdvisor());
		} catch (Exception e) {
			// TODO afficher un message au conseiller lui indiquant que l'ajout
			// n'a pas fonctionné
		}
	}

	public void removeCustomer(Customer customer) {
		getAdvisor().getCustomers().remove(customer);
		try {
			advisorService.merge(getAdvisor());
		} catch (Exception e) {
			// TODO afficher un message au conseiller lui indiquant que la
			// suppression n'a pas fonctionné
		}
	}
	
	public Collection<Advisor> getAllAdvisors() {
		Collection<Advisor> advisors = new ArrayList<>();
		try {
			advisors = advisorService.findAll();
		} catch (Exception e) {
			// TODO Afficher message qui indique que la liste n'a pas pu etre recup
		
		}
		return advisors;
	}

	public Collection<Customer> getCustomers() {
		Collection<Customer> customers = getAdvisor().getCustomers();
		return customers;
	}

	public Advisor getAdvisor() {
		return advisor;
	}

	public void setAdvisor(Advisor advisor) {
		this.advisor = advisor;
	}

	public AdvisorController() {
	}

}
