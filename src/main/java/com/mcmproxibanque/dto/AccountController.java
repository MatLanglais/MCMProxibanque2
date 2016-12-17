package com.mcmproxibanque.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

import com.mcmproxibanque.model.Account;
import com.mcmproxibanque.service.AccountService;
import com.mcmproxibanque.service.IService;

@ManagedBean
public class AccountController {

	private Account account;
	@Autowired
	private IService<Account> accountService;

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

	public void setAccount(Account account) {
		this.account = account;
	}

	public AccountController() {
	}

}
