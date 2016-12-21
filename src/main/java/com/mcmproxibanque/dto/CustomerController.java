package com.mcmproxibanque.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

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

	@Autowired
	private IService<Customer> customerService;
	@Autowired
	private IService<Account> accountService;

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

	public String modifyCustomer() {
		customer.setName(getCustomer().getName().trim());
		customer.setForename(getCustomer().getForename().trim());
		customer.setEmail(getCustomer().getEmail().trim());
		customer.setAddress(new Address(getCustomer().getAddress().getStreet().trim(),
				getCustomer().getAddress().getCity().trim(), getCustomer().getAddress().getZipCode()));
		try {
			customerService.merge(getCustomer());
			return "listeClients";
		} catch (Exception e) {
			// TODO Afficher message d'erreur
			return "error";
		}
	}

	public String removeCurrentAccount() {
		long id = getCustomer().getCurrentAccount().getId();
		getCustomer().setCurrentAccount(null);
		System.out.println(id);
		try {
			accountService.remove(id);
			customerService.merge(getCustomer());
			return "listeClients";
		} catch (Exception e) {
			// TODO Afficher message d'erreur la suppression n'a pas fonctionn�
			return "error";
		}
	}
	
	public String removeSavingAccount() {
		long id = getCustomer().getSavingAccount().getId();
		getCustomer().setSavingAccount(null);
		System.out.println(id);
		try {
			accountService.remove(getCustomer().getSavingAccount().getId());
			customerService.merge(getCustomer());
			return "listeClients";
		} catch (Exception e) {
			// TODO Afficher message d'erreur la suppression n'a pas fonctionn�
			return "error";

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
			// TODO Afficher message d'erreur l'ajout n'a pas fonctionn�
		}
	}

	

	// Methode pour afficher la liste des comptes d'un client
	public String listAccountByCustomer(String id) {
		Long idCustomer = Long.parseLong(id);
		System.out.println(idCustomer);
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

	// M�thode pour aller vers la page d'ajout de compte
	public String customerAccountCreationPage(String id) {
		Long idCustomer = Long.parseLong(id);
		try {
			customer = customerService.findById(Long.valueOf(idCustomer));
			return "creationCompte";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}

	// Methode pour v�rifier si le compte �pargne du client existe
	public boolean isSavingAccountExist() {
		if (customer.getSavingAccount() != null)
			return true;
		return false;
	}

	// Methode pour v�rifier si le compte courant du client existe
	public boolean isCurrentAccountExist() {
		if (customer.getCurrentAccount() != null)
			return true;
		return false;
	}

	// Methode pour v�rifier si l'attribut customer est rempli
	public boolean isCustomerExist() {
		if (customer != null && customer.getId() != 0)
			return true;
		return false;
	}

	// Methode pour v�rifier si l'attribut customer n'est pas rempli (oui, c'est
	// un peu stupide, mais c'est comme �a)
	public boolean isCustomerNotExist() {
		System.out.println(customer);
		if (customer == null || customer.getId() == 0)
			return true;
		return false;
	}

	// Methode pour rediriger l'utilisateur vers la page de cr�ation d'un client
	public String customerCreationPage() {
		customer = new Customer();
		return "creationClient.xhtml";
	}
	
	public String customerAddAccountPage(String id) {
		Long idCustomer = Long.parseLong(id);
		try {
			customer = customerService.findById(idCustomer);
			return "creationCompte.xhtml";
		} catch (Exception e) {
			e.printStackTrace();
			return "error.xhtml";
		}
}


	// Methode pour rediriger l'utilisateur vers la page d'�dition d'un client
	public String customerEditionPage(String id) {
		Long idCustomer = Long.parseLong(id);
		try {
			customer = customerService.findById(idCustomer);
			return "editionClient.xhtml";
		} catch (Exception e) {
			e.printStackTrace();
			return "error.xhtml";
		}

	}

	// M�thode pour rediriger l'utilisateur vers la page de virement (avec un
	// utilisateur stock�)
	public String customerTransferPage(String id) {
		Long idCustomer = Long.parseLong(id);
		try {
			customer = customerService.findById(idCustomer);
			System.out.println(customer);
			return "/views/advisor/virement.xhtml";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}

	// M�thode pour rediriger l'utilisateur vers la page de virement (sans
	// utilisateur stock�)
	public String customerTransferPage() {
		customer = null;
		return "/views/advisor/virement.xhtml";

	}

	// M�thode pour ajouter un customer � la base de donn�es
	public String addCustomer() {
		customer.setName(getCustomer().getName().trim());
		customer.setForename(getCustomer().getForename().trim());
		customer.setEmail(getCustomer().getEmail().trim());
		customer.setAddress(new Address(getCustomer().getAddress().getStreet().trim(),
				getCustomer().getAddress().getCity().trim(), getCustomer().getAddress().getZipCode()));
		
		try {
			customerService.persist(customer);
			return "listeClients";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error.xhtml";
		}
	}

	// M�thode pour aller � la page de suppression d'un client
	public String customerDeletionPage(String id) {
		Long idCustomer = Long.parseLong(id);
		try {
			customer = customerService.findById(idCustomer);
			return "suppressionClients.xhtml";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

	}

	// M�thode pour retourner � l'accueil
	public String goAccueil() {
		return "listeClients.xhtml";
	}

	// Verifier si un client est a decouvert
	public boolean isOverdraft(Customer c) {
		if (c != null) {
			//TODO utiliser les methodes subalternes
			if (c.getSavingAccount() != null && c.getSavingAccount().getAmount() < 0)
				return true;
			if (c.getCurrentAccount() != null
					&& c.getCurrentAccount().getAmount() < -1 * c.getCurrentAccount().getOverdraft())
				return true;
		} else {
			return false;
		}
		return false;
	}

	public boolean isSavingAccountOverdraft(SavingAccount account) {
		if (account != null && account.getAmount() < 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isCurrentAccountOverdraft(CurrentAccount account) {
		if (account != null && account.getAmount() < -1 * account.getOverdraft()) {
			return true;
		} else {
			return false;
		}
	}

	// M�thode MAJ du customer dans le controller
	public void updateCustomerInController() {
		try {
			customer = customerService.findById(customer.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		
		this.customer = customer;

	}

	// M�thode de suppression d'un client
	public String removeCustomer() {
		try {
			customerService.remove(getCustomer().getId());
			customer = null;
			return "listeClients.xhtml";
		} catch (Exception e) {
			e.printStackTrace();
			return "error.xhtml";
		}
	}

}
