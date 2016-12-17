package com.mcmproxibanque.dto;

import javax.faces.bean.ManagedBean;

import com.mcmproxibanque.model.Account;

@ManagedBean
public class AccountController {

	private Account account;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public AccountController() {
	}
	
}
