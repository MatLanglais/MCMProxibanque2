package com.mcmproxibanque.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcmproxibanque.model.Account;
import com.mcmproxibanque.model.Address;
import com.mcmproxibanque.model.Advisor;
import com.mcmproxibanque.model.CurrentAccount;
import com.mcmproxibanque.model.Customer;
import com.mcmproxibanque.model.SavingAccount;
import com.mcmproxibanque.service.AdvisorService;
import com.mcmproxibanque.service.IService;

/**
 * <b>ManagedBean CustomerController</b>
 * <p>
 * Controller JSF du {@link Customer} .<br />
 * Il est définit par :
 * <ul>
 * <li>customer : {@link Customer} stocké dans le controller</li>
 * </ul>
 * </p>
 * 
 * @author Claire Steinmacher
 * @author Mathilde Terrioux
 * @author Mathieu Langlais
 * 
 * @version 1
 * 
 * 
 * @see {@link Customer}
 * 
 */
@ManagedBean
@Component
public class CustomerController {
	Customer customer;

	@Autowired
	private IService<Customer> customerService;
	@Autowired
	private IService<Account> accountService;
	@Autowired
	private AdvisorService advisorService;

	// Getters & Setters
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {

		this.customer = customer;

	}

	// Méthode pour obtenir la liste de tout les customers
	/**
	 * @return {@link Collection} de tout les {@link Customer} en base de données
	 * @throws Exception
	 */
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

	/**
	 * @return redirection après modification
	 */
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

	// Méthode pour supprimer un compte courant
	/**
	 * @return redirection après suppression du compte courant
	 */
	public String removeCurrentAccount() {
		long id = getCustomer().getCurrentAccount().getId();
		getCustomer().setCurrentAccount(null);
		try {
			customerService.merge(getCustomer());
			accountService.remove(id);
			return "listeClients";
		} catch (Exception e) {
			// TODO Afficher message d'erreur la suppression n'a pas fonctionné
			return "error";
		}
	}

	// Méthode pour supprimer un compte épargne
	/**
	 * @return redirection après suppression du compte épargne
	 */
	public String removeSavingAccount() {
		long id = getCustomer().getSavingAccount().getId();
		getCustomer().setSavingAccount(null);
		try {
			customerService.merge(getCustomer());
			accountService.remove(id);
			return "listeClients";
		} catch (Exception e) {
			// TODO Afficher message d'erreur la suppression n'a pas fonctionné
			return "error";

		}
	}

	// Méthode pour ajouter un compte
	/**
	 * @param account - {@link Account} à ajouter au {@link Customer}
	 * @param type - current pour un compte courant, saving pour un compte épargne
	 */
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

	// Methode pour afficher la liste des comptes d'un client
	/**
	 * @param id - id du {@link Customer}
	 * @return redirection après recupération de la liste des comptes
	 */
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

	// Méthode pour aller vers la page d'ajout de compte
	/**
	 * @param id - id du {@link Customer}
	 * @return redirection pour aller vers l'ajout du compte
	 */
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

	// Methode pour vérifier si le compte épargne du client existe
	/**
	 * @return {@link Boolean} true si {@link SavingAccount} existe
	 */
	public boolean isSavingAccountExist() {
		if (customer.getSavingAccount() != null)
			return true;
		return false;
	}

	// Methode pour vérifier si le compte courant du client existe
	/**
	 * @return {@link Boolean} true si {@link CurrentAccount} existe
	 */
	public boolean isCurrentAccountExist() {
		if (customer.getCurrentAccount() != null)
			return true;
		return false;
	}

	// Methode pour vérifier si l'attribut customer est rempli
	/**
	 * @return {@link Boolean} true si customer not null
	 */
	public boolean isCustomerExist() {
		if (customer != null && customer.getId() != 0)
			return true;
		return false;
	}

	// Methode pour vérifier si l'attribut customer n'est pas rempli (oui, c'est
	// un peu stupide, mais c'est comme ça)
	/**
	 * @return {@link Boolean} true si customer null
	 */
	public boolean isCustomerNotExist() {
		System.out.println(customer);
		if (customer == null || customer.getId() == 0)
			return true;
		return false;
	}

	// Methode pour rediriger l'utilisateur vers la page de création d'un client
	/**
	 * @return redirection vers la page de création d'un client
	 */
	public String customerCreationPage() {
		customer = new Customer();
		return "creationClient.xhtml";
	}

	// Méthode pour rediriger vers la page de création de compte d'un client
	/**
	 * @param id - id du {@link Customer}
	 * @return redirection vers la page de création de compte
	 */
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

	// Methode pour rediriger l'utilisateur vers la page d'édition d'un client
	/**
	 * @param id - id du {@link Customer}
	 * @return redirection vers la page édition d'un {@link Customer}
	 */
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

	// Méthode pour rediriger l'utilisateur vers la page de virement (avec un
	// utilisateur stocké)
	/**
	 * @param id - id du {@link Customer}
	 * @return redirection vers la page de virement avec un {@link Customer} stocké dans le controller
	 */
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

	// Méthode pour rediriger l'utilisateur vers la page de virement (sans
	// utilisateur stocké)
	/**
	 * @return redirection vers la page de virement avec customer null
	 */
	public String customerTransferPage() {
		customer = null;
		return "/views/advisor/virement.xhtml";

	}

	// Méthode pour ajouter un customer à la base de données
	/**
	 * @return redirection apres ajout d'un {@link Customer} a la base de données
	 */
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

	// Méthode pour retourner à l'accueil
	public String goAccueil() {
		return "listeClients.xhtml";
	}

	// Verifier si un client est a decouvert
	public boolean isOverdraft(Customer c) {
		if (c != null) {
			// TODO utiliser les methodes subalternes
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

	// Méthode MAJ du customer dans le controller
	public void updateCustomerInController() {
		try {
			customer = customerService.findById(customer.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Méthode de suppression d'un client
	public String removeCustomer(long idCustomer) {
		try {
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
					.getSession(true);
			Advisor advisor = (Advisor) session.getAttribute("advisorsession");
			customer = customerService.findById(idCustomer);
			System.out.println(customer);
			advisorService.getCustomersOfAdvisor(advisor.getId()).remove(customer);
			advisorService.merge(advisor);
		//	customerService.remove(customer.getId());
			this.customer = null;
			return "listeClients.xhtml";
		} catch (Exception e) {
			e.printStackTrace();
			return "error.xhtml";
		}
	}

}
