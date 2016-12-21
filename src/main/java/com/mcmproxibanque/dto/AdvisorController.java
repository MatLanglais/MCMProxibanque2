package com.mcmproxibanque.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcmproxibanque.model.Address;
import com.mcmproxibanque.model.Advisor;
import com.mcmproxibanque.model.Customer;
import com.mcmproxibanque.service.AdvisorService;
import com.mcmproxibanque.service.CustomerService;

@ManagedBean
@Component
@SessionScoped
public class AdvisorController {

	private Advisor advisor = new Advisor();

	@Autowired
	private AdvisorService advisorService;
	@Autowired
	private CustomerService customerService;

	// Méthode de connexion
	public String loginVerif() {
		boolean testvar = false;
		List<Advisor> advisorList = new ArrayList<>();
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		try {
			advisorList = advisorService.findAll();
			for (Advisor advisorl : advisorList) {
				if (advisor.getLogin().equals(advisorl.getLogin())
						&& advisor.getPassword().equals(advisorl.getPassword())) {
					advisor = advisorl;
					HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
							.getSession(true);
					session.setAttribute("advisorsession", advisor);
					testvar = true;
					return "/views/advisor/listeClients.xhtml";
				}
			}
			if (!testvar) {
				return "/erreurlogin.xhtml";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "/erreurlogin.xhtml";
		}
		return "/erreurlogin.xhtml";
	}

	// Méthode de déconnexion
	public String disconnect() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.invalidate();
		return "/userChoice.xhtml";
	}

	public String addCustomer(Customer customer) {
		customer.setName(customer.getName().trim());
		customer.setForename(customer.getForename().trim());
		customer.setEmail(customer.getEmail().trim());
		customer.setAddress(new Address(customer.getAddress().getStreet().trim(),
				customer.getAddress().getCity().trim(), customer.getAddress().getZipCode()));
		getCustomersOfAdvisor(advisor.getId()).add(customer);
		try {
			advisorService.merge(getAdvisor());
			customerService.persist(customer);
			return "listeClients";
		} catch (Exception e) {
			e.printStackTrace();
			return "error.xhtml";
		}
	}

	public String removeCustomer(Customer customer) {
		getCustomersOfAdvisor(advisor.getId()).remove(customer);
		try {
			advisorService.merge(getAdvisor());
			customerService.remove(customer.getId());
			return "/views/advisor/listeClients.xhtml";
		} catch (Exception e) {
			return "Echec de la suppression";
			// TODO afficher un message au conseiller lui indiquant que la
			// suppression n'a pas fonctionné
		}
	}

	public String goAccueil() {
		return "accueil.xhtml";
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
		return customers;
	}

	public Advisor getAdvisor() {
		return advisor;
	}

	public void setAdvisor(Advisor advisor) {
		advisor.setName(advisor.getName().trim());
		advisor.setForename(advisor.getForename().trim());
		advisor.setLogin(advisor.getLogin().trim());
		advisor.setPassword(advisor.getPassword().trim());
		this.advisor = advisor;
	}

	public AdvisorController() {
	}

}
