package com.mcmproxibanque.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

import com.mcmproxibanque.model.Account;
import com.mcmproxibanque.model.CurrentAccount;
import com.mcmproxibanque.model.Customer;
import com.mcmproxibanque.model.SavingAccount;
import com.mcmproxibanque.service.CustomerService;

@ManagedBean
public class CustomerController {
	private Customer customer;
	@Autowired
	private CustomerService customerService;

	public Collection<Customer> getAllCustomers() {
		Collection<Customer> customers = new ArrayList<>();
		try {
			customers = customerService.findAll();
		} catch (Exception e) {
			// TODO Afficher un message "BD non dispo"
		}
		return customers;

	}
	
	public void modifyCustomer(){
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

	
	public void removeAccount(Account account){
		if(account.equals(getCustomer().getCurrentAccount())){
			getCustomer().setCurrentAccount(null);
		}else if(account.equals(getCustomer().getSavingAccount())){
			getCustomer().setSavingAccount(null);
		}else{
			//TODO renvoyer message: ce compte n'appartient pas a ce client (hum?)
		}
		try {
			customerService.merge(getCustomer());
		} catch (Exception e) {
			// TODO Afficher message d'erreur la suppression n'a pas fonctionné
		}
	}
	
	public void addAccount(Account account, String type){
		if(type.equalsIgnoreCase("current")){
			getCustomer().setCurrentAccount((CurrentAccount) account);
		}else if(type.equalsIgnoreCase("saving")){
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
}
