package com.mcmproxibanque.dto;

import java.util.Collection;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.mcmproxibanque.model.Advisor;
import com.mcmproxibanque.model.Customer;
import com.mcmproxibanque.service.EmployeeService;
import com.mcmproxibanque.service.IService;

@ManagedBean
public class AdvisorController {

	private Advisor advisor;
	// TEST a voir si fonctionne avec interface untyped
	@Autowired
	private IService advisorService;

	public void addCustomer(Customer customer) {
//		getAdvisor().getCustomersMap().put(customer.getId(), customer);
		getAdvisor().getCustomers().add(customer);
		try {
			advisorService.merge(getAdvisor());
		} catch (Exception e) {
			// TODO afficher un message au conseiller lui indiquant que l'ajout
			// n'a pas fonctionné
		}
	}

	public void removeCustomer(Customer customer) {
//		getAdvisor().getCustomersMap().remove(customer.getId());
		getAdvisor().getCustomers().remove(customer);
		try {
			advisorService.merge(getAdvisor());
		} catch (Exception e) {
			// TODO afficher un message au conseiller lui indiquant que la
			// suppression n'a pas fonctionné
		}
	}
	
	public Collection<Advisor> getAllAdvisors() throws Exception {
		Collection<Advisor> advisors = advisorService.findAll();
		return advisors;
	}

	public Collection<Customer> getCustomers() {
//		Collection<Customer> customers = getAdvisor().getCustomersMap().values();
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
