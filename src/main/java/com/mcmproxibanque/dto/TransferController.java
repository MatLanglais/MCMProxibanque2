package com.mcmproxibanque.dto;

import java.util.Calendar;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcmproxibanque.model.Customer;
import com.mcmproxibanque.model.Transfer;
import com.mcmproxibanque.model.TransferDate;
import com.mcmproxibanque.service.ITransferService;

@ManagedBean
@Component
public class TransferController {

	private Transfer transfer;
	private Customer toCustomer;
	private Customer fromCustomer;
	private Long toAccountId;
	private Long fromAccountId;
	private double amount;

	@Autowired
	ITransferService transferService;

	// Constructeur
	public TransferController() {
	}

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

	public Long getToAccountId() {
		return toAccountId;
	}

	public void setToAccountId(Long toAccountId) {
		this.toAccountId = toAccountId;
	}

	public Long getFromAccountId() {
		return fromAccountId;
	}

	public void setFromAccountId(Long fromAccountId) {
		this.fromAccountId = fromAccountId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public ITransferService getTransferService() {
		return transferService;
	}

	public void setTransferService(ITransferService transferService) {
		this.transferService = transferService;
	}

	// Methode pour v�rifier si le compte �pargne du client existe
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

	// Methode pour v�rifier si le compte courant du client existe
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

	public void onOwnerChange() {

	}

	// M�thode pour faire le transfer �O
	public String doTransfer() {
		Calendar now = Calendar.getInstance();
		int day = now.get(Calendar.DAY_OF_MONTH);
		int month = now.get(Calendar.MONTH) + 1;
		int year = now.get(Calendar.YEAR);
		int week = now.get(Calendar.WEEK_OF_YEAR);
		transfer = new Transfer();
		transfer.setDate(new TransferDate(day, week, month, year));
		transfer.setFromAccount(fromAccountId);
		transfer.setToAccount(toAccountId);
		transfer.setAmount(amount);

		System.out.println(transfer);

		transferService.doTransfer(transfer);
		
		transfer = new Transfer();

		return "cvir";
	}
}
