package com.mcmproxibanque.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcmproxibanque.dao.interfaces.IAccountDao;
import com.mcmproxibanque.model.Account;
import com.mcmproxibanque.model.CurrentAccount;
import com.mcmproxibanque.model.Customer;
import com.mcmproxibanque.model.SavingAccount;
import com.mcmproxibanque.service.IService;

/**
 * <b>ManagedBean AccountController</b>
 * <p>
 * Controller JSF du compte.<br />
 * Il est définit par :
 * <ul>
 * <li>account : {@link Account} stocké dans le controller</li>
 * <li>accountType : {@link String} permettant de préciser le type du compte</li>
 * <li>amount : montant sur le compte.</li>
 * </ul> 
 * </p>
 * 
 * @author Claire Steinmacher
 * @author Mathilde Terrioux
 * @author Mathieu Langlais
 * 
 * @version 1
 * 

 * @see {@link Advisor}
 * 
 */
@ManagedBean
@Component
public class AccountController {

	private Account account;
	String accountType = "";
	double amount;

	@Autowired
	private IService<Account> accountService;
	@Autowired
	private IService<Customer> customerService;
	
	// Constructor
	public AccountController() {
	}
	
	// Getters & Setters
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @return {@link List} de tout les comptes
	 */
	// Méthode permettant d'obtenir la liste de tout les comptes
	public Collection<Account> getAllAccounts() {
		Collection<Account> accounts = new ArrayList<>();
		try {
			accounts = accountService.findAll();
		} catch (Exception e) {
			// TODO Afficher message qui indique que la liste n'a pas pu etre
			// recup

		}
		return accounts;
	}

	/**
	 * @param id - Id du compte
	 * @return compte
	 * @throws Exception
	 */
	// Méthode permettant de récupérer un compte par id
	public Account getAccountById(String id) throws Exception {
		Long accountId = Long.parseLong(id);
		account = accountService.findById(accountId);
		return account;
	}

	/**
	 * @param id - id du customer
	 * @return
	 */
	// Méthode permettant de créer un compte
	public String createAccount(String id) {
		Long idCustomer = Long.parseLong(id);
		Customer customer;
		try {
			customer = customerService.findById(idCustomer);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

		if ("ca".equals(accountType)) {
			customer.setCurrentAccount(new CurrentAccount());
			customer.getCurrentAccount().setAmount(amount);
			try {
				customerService.merge(customer);
			} catch (Exception e) {
				e.printStackTrace();
				return "error";
			}
		}
		if ("sa".equals(accountType)) {
			customer.setSavingAccount(new SavingAccount());
			customer.getSavingAccount().setAmount(amount);
			try {
				customerService.merge(customer);
			} catch (Exception e) {
				e.printStackTrace();
				return "error";
			}
		}
		accountType = "";
		amount = 0;
		return "listeClients";
	}


}
