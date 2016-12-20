package com.mcmproxibanque.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcmproxibanque.model.Advisor;
import com.mcmproxibanque.model.Customer;
import com.mcmproxibanque.service.AdvisorService;
import com.mcmproxibanque.service.CustomerService;

@ManagedBean
@Component
public class AdvisorController {

	private Advisor advisor;
	@Autowired
	private AdvisorService advisorService;
	@Autowired
	private CustomerService customerService;

	public void addCustomer(Customer customer) {
		getCustomersOfAdvisor(advisor).add(customer);
		try {
			advisorService.merge(getAdvisor());

		} catch (Exception e) {
			// TODO afficher un message au conseiller lui indiquant que l'ajout
			// n'a pas fonctionné
		}
	}

	public String removeCustomer(Customer customer) {
		getCustomersOfAdvisor(advisor).remove(customer);
		try {
			advisorService.merge(getAdvisor());
			customerService.remove(customer.getId());
			return "accueil.xhtml";
		} catch (Exception e) {
			return "Echec de la suppression";
			// TODO afficher un message au conseiller lui indiquant que la
			// suppression n'a pas fonctionné
		}
	}

	public Collection<Advisor> getAllAdvisors() {
		Collection<Advisor> advisors = new ArrayList<>();
		try {
			advisors = advisorService.findAll();
		} catch (Exception e) {
			// TODO Afficher message qui indique que la liste n'a pas pu etre
			// recup

		}
		return advisors;
	}

	public Collection<Customer> getCustomersOfAdvisor(Advisor advisor) {
		Collection<Customer> customers = advisorService.getCustomersOfAdvisor(advisor);
		// Collection<Customer> customers = getAdvisor().getCustomers();
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
