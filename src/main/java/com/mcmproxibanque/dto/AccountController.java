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
import com.mcmproxibanque.model.Customer;
import com.mcmproxibanque.service.IService;

@ManagedBean
@Component
public class AccountController {

	private Account account;

	@Autowired
	private IService<Account> accountService;
	@Autowired
	private IService<Customer> customerService;

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

	public Account getAccount(Long idclient) {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public AccountController() {
	}

}
