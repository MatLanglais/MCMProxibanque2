package com.mcmproxibanque.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.mcmproxibanque.model.Advisor;
import com.mcmproxibanque.model.Customer;
import com.mcmproxibanque.service.AdvisorService;
import com.mcmproxibanque.service.EmployeeService;
import com.mcmproxibanque.service.IService;

@ManagedBean
public class AdvisorController {

	private Advisor advisor;
	// TEST a voir si fonctionne sans interface
	@Autowired
	private AdvisorService advisorService;

	public void addCustomer(Customer customer) {
		getAdvisor().getCustomersMap().put(customer.getId(), customer);
		try {
			advisorService.merge(getAdvisor());
		} catch (Exception e) {
			// TODO afficher un message au conseiller lui indiquant que l'ajout
			// n'a pas fonctionné
		}
	}

	public void removeCustomer(Customer customer) {
		getAdvisor().getCustomersMap().remove(customer.getId());
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
		Collection<Customer> customers = getAdvisor().getCustomersMap().values();
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
