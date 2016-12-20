package com.mcmproxibanque.dto;

import javax.faces.bean.ManagedBean;

import org.springframework.stereotype.Component;

import com.mcmproxibanque.model.Customer;
import com.mcmproxibanque.model.Transfer;

import antlr.build.Tool;

@ManagedBean
@Component
public class TransferController {

	private Transfer transfer = new Transfer();
	private Customer toCustomer = new Customer();
	private Customer fromCustomer = new Customer();

	// Getters & Setters
	public Customer getToCustomer() {
		return toCustomer;
	}

	public void setToCustomer(Customer toCustomer) {
		this.toCustomer = toCustomer;
	}

	public Customer getFromCustomer() {
		return fromCustomer;
	}

	public void setFromCustomer(Customer fromCustomer) {
		this.fromCustomer = fromCustomer;
	}

	public Transfer getTransfer() {
		return transfer;
	}

	public void setTransfer(Transfer transfer) {
		this.transfer = transfer;
	}

	public TransferController() {
	}

	// Methode pour vérifier si le compte épargne du client existe
	public boolean isFromSavingAccountExist() {
		if (fromCustomer.getSavingAccount() != null)
			return true;
		return false;
	}
	public boolean isToSavingAccountExist() {
		if (toCustomer.getSavingAccount() != null)
			return true;
		return false;
	}

	// Methode pour vérifier si le compte courant du client existe
	public boolean isFromCurrentAccountExist() {
		if (fromCustomer.getCurrentAccount() != null)
			return true;
		return false;
	}
	public boolean isToCurrentAccountExist() {
		if (toCustomer.getCurrentAccount() != null)
			return true;
		return false;
	}

	public void onOwnerChange(){
		
	}
}
