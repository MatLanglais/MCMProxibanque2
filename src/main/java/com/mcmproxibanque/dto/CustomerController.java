package com.mcmproxibanque.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.mcmproxibanque.model.Account;
import com.mcmproxibanque.model.CurrentAccount;
import com.mcmproxibanque.model.Customer;
import com.mcmproxibanque.model.SavingAccount;
import com.mcmproxibanque.service.CustomerService;
import com.mcmproxibanque.service.ICustomerService;
import com.mcmproxibanque.service.IService;

@ManagedBean
@Component
public class CustomerController {
	private Customer customer;

	@Autowired
	private IService<Customer> customerService;

	// ApplicationContext context = new
	// ClassPathXmlApplicationContext("/META-INF/spring/applicationContext-db-mysql.xml");
	// IService<Customer> customerService = context.getBean("customerService",
	// CustomerService.class);

	public Collection<Customer> getAllCustomers() throws Exception {
		Collection<Customer> customers = new ArrayList<>();
		System.out.println(customerService);
		try {
			customers = customerService.findAll();
		} catch (Exception e) {
			// TODO Afficher un message "BD non dispo"
			e.printStackTrace();
		}
		return customers;

	}

	public void modifyCustomer() {
		try {
			customerService.merge(getCustomer());
		} catch (Exception e) {
			// TODO Afficher message d'erreur
		}
	}

	public Account getSavingAccount() {
		Account savingAccount = getCustomer().getSavingAccount();
		return savingAccount;

	}

	public Account getCurrentAccount() {
		Account currentAccount = getCustomer().getCurrentAccount();
		return currentAccount;

	}

	public void removeAccount(Account account) {
		if (account.equals(getCustomer().getCurrentAccount())) {
			getCustomer().setCurrentAccount(null);
		} else if (account.equals(getCustomer().getSavingAccount())) {
			getCustomer().setSavingAccount(null);
		} else {
			// TODO renvoyer message: ce compte n'appartient pas a ce client
			// (hum?)
		}
		try {
			customerService.merge(getCustomer());
		} catch (Exception e) {
			// TODO Afficher message d'erreur la suppression n'a pas fonctionné
		}
	}

	public void addAccount(Account account, String type) {
		if (type.equalsIgnoreCase("current")) {
			getCustomer().setCurrentAccount((CurrentAccount) account);
		} else if (type.equalsIgnoreCase("saving")) {
			getCustomer().setSavingAccount((SavingAccount) account);
		}
		try {
			customerService.merge(getCustomer());
		} catch (Exception e) {
			// TODO Afficher message d'erreur l'ajout n'a pas fonctionné
		}
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public CustomerController() {

	}

	// Methode pour afficher la liste des comptes d'un client
	public String listAccountByCustomer(String id) {
		System.out.println("Dans le controller Account");
		Long idCustomer = Long.parseLong(id);
		try {
			customer = customerService.findById(Long.valueOf(idCustomer));
			System.out.println("customer : " + customer);
			return "listeComptes";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}

	}
	
	// Methode pour vérifier si le compte épargne du client existe
	public boolean isSavingAccountExist(){
		if (customer.getSavingAccount() != null)
			return true;
		return false;
	}
	// Methode pour vérifier si le compte courant du client existe
	public boolean isCurrentAccountExist(){
		if (customer.getCurrentAccount() != null)
			return true;
		return false;
	}
}
