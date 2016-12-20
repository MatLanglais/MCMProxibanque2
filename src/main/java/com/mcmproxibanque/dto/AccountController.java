package com.mcmproxibanque.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcmproxibanque.model.Account;
import com.mcmproxibanque.model.CurrentAccount;
import com.mcmproxibanque.model.Customer;
import com.mcmproxibanque.model.SavingAccount;
import com.mcmproxibanque.service.ICustomerService;
import com.mcmproxibanque.service.IService;

@ManagedBean
@Component
public class AccountController {

	private Account account;
	String accountType = "";
	double amount;

	@Autowired
	private IService<Account> accountService;
	@Autowired
	private ICustomerService customerService;
	
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

	public Account getAccount() {
		return account;
	}

	public Account getAccountById(String id) throws Exception {
		Long accountId = Long.parseLong(id);
		System.out.println(accountId);
		account = accountService.findById(accountId);
		System.out.println(account);
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

	public AccountController() {
	}

	// Méthode pour créer un compte
	public String createAccount(String id) {
		System.out.println("Dans la méthode pour créer un compte");
		Long idCustomer = Long.parseLong(id);
		Customer customer;
		try {
			customer = customerService.findById(idCustomer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		System.out.println("client : " + customer);

		if ("ca".equals(accountType)) {
			customer.setCurrentAccount(new CurrentAccount());
			customer.getCurrentAccount().setOverdraft((double) 1000);
			customer.getCurrentAccount().setAmount(amount);
			try {
				customerService.merge(customer);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "error";
			}
		}
		if ("sa".equals(accountType)) {
			customer.setSavingAccount(new SavingAccount());
			customer.getSavingAccount().setRate(0.3);
			customer.getSavingAccount().setAmount(amount);
			try {
				customerService.merge(customer);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "error";
			}
		}
		accountType = "";
		amount = 0;
		return "listeClients";
	}

}
