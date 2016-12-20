package com.mcmproxibanque.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcmproxibanque.model.Advisor;
import com.mcmproxibanque.model.Customer;
import com.mcmproxibanque.service.AdvisorService;

@ManagedBean
@Component
@SessionScoped
public class AdvisorController {

	private Advisor advisor;
	private String login;
	private String password;
	@Autowired
	private AdvisorService advisorService;
	

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
			// TODO Afficher message qui indique que la liste n'a pas pu etre
			// recup

		}
		return advisors;
	}

	public Collection<Customer> getCustomersOfAdvisor(long id) {
		Collection<Customer> customers = advisorService.getCustomersOfAdvisor(id);
//		Collection<Customer> customers = getAdvisor().getCustomers();
		return customers;
	}

	
	public Advisor getAdvisor() {
		return advisor;
	}

	public void setAdvisor(Advisor advisor) {
		this.advisor = advisor;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AdvisorController() {
	}
	
	// Méthode pour s'authentifier
	public String loginVerif() {
		System.out.println("login : " + login + ", mdp = " + password);
		List<Advisor> advisorList = new ArrayList<>();
		try {
			advisorList = advisorService.findAll();
			for (Advisor advisorl : advisorList) {
				if (login.equals(advisorl.getLogin()) && password.equals(advisorl.getPassword()))
					advisor = advisorl;
				System.out.println(advisor);
				HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
				session.setAttribute("advisorsession", advisor);
				return "/views/advisor/listeClients.xhtml";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}

		return "error";
	}

}
