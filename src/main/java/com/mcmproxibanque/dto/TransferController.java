package com.mcmproxibanque.dto;

import java.util.Calendar;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.BarChartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcmproxibanque.model.Account;
import com.mcmproxibanque.model.Customer;
import com.mcmproxibanque.model.Transfer;
import com.mcmproxibanque.model.TransferDate;
import com.mcmproxibanque.service.ITransferService;
/**
 * <b>ManagedBean TransferController</b>
 * <p>
 * Controller JSF des {@link Transfer} .<br />
 * Il est définit par :
 * <ul>
 * <li>transfer : {@link Transfer}</li>
 * <li>histoTransfer : {@link Transfer} dans l'historique</li>
 * <li>toCustomer : {@link Customer} débité</li>
 * <li>fromCustomer : {@link Customer} crédité</li>
 * <li>toAccountId : id du {@link Account} débité</li>
 * <li>fromAccountId : id du {@link Account} crédité</li>
 * <li>amout : montant du {@link Transfer}</li>
 * </ul>
 * </p>
 * 
 * @author Claire Steinmacher
 * @author Mathilde Terrioux
 * @author Mathieu Langlais
 * 
 * @version 1
 * 
 */
@ManagedBean
@Component
public class TransferController {

	private Transfer transfer;
	private Transfer histoTransfer;
	private Customer toCustomer;
	private Customer fromCustomer;
	private Long toAccountId;
	private Long fromAccountId;
	private double amount;

	@Autowired
	ITransferService transferService;

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

	public void onOwnerChange() {

	}

	// Méthode pour faire le transfer ôO
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
		
		histoTransfer = transfer;
//		histoTransfer.setAmount(transfer.getAmount());
//		histoTransfer.setFromAccount(transfer.getFromAccount());
//		histoTransfer.setToAccount(transfer.getToAccount());
//		histoTransfer.setDate(transfer.getDate());
		
		transfer = new Transfer();
		
		System.out.println(transfer);

		return "cvir";
	}
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

		public Transfer getHistoTransfer() {
			return histoTransfer;
		}

		public void setHistoTransfer(Transfer histoTransfer) {
			this.histoTransfer = histoTransfer;
		}

}
