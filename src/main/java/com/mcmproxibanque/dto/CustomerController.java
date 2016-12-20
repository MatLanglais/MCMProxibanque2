package com.mcmproxibanque.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.faces.bean.ManagedBean;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcmproxibanque.model.Account;
import com.mcmproxibanque.model.Address;
import com.mcmproxibanque.model.CurrentAccount;
import com.mcmproxibanque.model.Customer;
import com.mcmproxibanque.model.SavingAccount;
import com.mcmproxibanque.service.IService;

@ManagedBean
@Component
public class CustomerController {
	Customer customer;
	Account account = new Account();

	@Autowired
	private IService<Customer> customerService;

	public Collection<Customer> getAllCustomers() throws Exception {
		Collection<Customer> customers = new ArrayList<>();
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

	public void removeAccount() {
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

	// Methode pour afficher la liste des comptes d'un client
	public String listAccountByCustomer(String id) {
		Long idCustomer = Long.parseLong(id);
		try {
			customer = customerService.findById(Long.valueOf(idCustomer));
			System.out.println(customer);
			return "listeComptes";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}

	}

	// Methode pour vérifier si le compte épargne du client existe
	public boolean isSavingAccountExist() {
		if (customer.getSavingAccount() != null)
			return true;
		return false;
	}

	// Methode pour vérifier si le compte courant du client existe
	public boolean isCurrentAccountExist() {
		if (customer.getCurrentAccount() != null)
			return true;
		return false;
	}

	// Methode pour vérifier si l'attribut customer est rempli
	public boolean isCustomerExist() {
		System.out.println(customer);
		if (customer != null && customer.getId() != 0)
			return true;
		return false;
	}

	// Methode pour vérifier si l'attribut customer n'est pas rempli (oui, c'est
	// un peu stupide, mais c'est comme ça)
	public boolean isCustomerNotExist() {
		System.out.println(customer);
		if (customer == null || customer.getId() == 0)
			return true;
		return false;
	}

	// Methode pour rediriger l'utilisateur vers la page de création d'un client
	public String customerCreationPage() {
		customer = new Customer();
		return "creationClient.xhtml";
	}

	// Methode pour rediriger l'utilisateur vers la page d'édition d'un client
	public String customerEditionPage(String id) {
		Long idCustomer = Long.parseLong(id);
		try {
			customer = customerService.findById(idCustomer);
			return "editionClient.xhtml";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}

	}

	// Méthode pour ajouter un customer à la base de données
	public String addCustomer() {
		System.out.println(customer);
		try {
			customerService.persist(customer);
			return "accueil.xhtml";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error.xhtml";
		}
	}

	// Remettre à 0 le formulaire d'ajout du client
	public void refreshCustomerForm() {
		this.customer = new Customer();
		this.customer.setAddress(new Address());
	}

	public void resetCustomer() {
		refreshCustomerForm();
		RequestContext.getCurrentInstance().reset("formAjoutClient:panel");
	}

	// Remettre à 0 le formulaire de création de compte
	public void refreshAccountForm() {

		if ((this.customer.getCurrentAccount() != null) & (this.customer.getSavingAccount() != null)) {

		} else {
			if (this.customer.getCurrentAccount() != null) {

				this.customer.setSavingAccount(new SavingAccount());

			} else {
				this.customer.setCurrentAccount(new CurrentAccount());
			}
		}
	}

	// Ajouter un compte à un client et redirri

}
