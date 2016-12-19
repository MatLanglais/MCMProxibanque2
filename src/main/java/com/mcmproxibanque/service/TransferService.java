package com.mcmproxibanque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcmproxibanque.dao.interfaces.ITransferDao;
import com.mcmproxibanque.model.Account;
import com.mcmproxibanque.model.Transfer;

@Component
public class TransferService implements IService<Transfer> {

	//@Autowired
	ITransferDao transferDaoImpl;
	
	@Autowired
	IService<Account> accountService;
	
	@Override
	public void persist(Transfer e) throws Exception {
		transferDaoImpl.persist(e);
	}

	@Override
	public void merge(Transfer e) throws Exception {
		transferDaoImpl.merge(e);
	}

	@Override
	public void remove(Object id) throws Exception {
		transferDaoImpl.remove(id);
	}

	@Override
	public Transfer findById(Object id) throws Exception {
		return transferDaoImpl.findById(id);
	}

	@Override
	public List<Transfer> findAll() throws Exception {
		return transferDaoImpl.findAll();
	}
	
	/**
	 * @param toAccountId - Id du Compte à débiter
	 * @param fromAccountId - Id du Compte à créditer
	 * @return - boolean renvoyant si le virement à été effectué ou non
	 */
	public boolean doTransfer(Transfer t){
		
		try {
			long toAccountId = t.getToAccount();
			long fromAccountId = t.getFromAccount();
			
			Account toAccount = accountService.findById(toAccountId);
			Account fromAccount = accountService.findById(fromAccountId);
			
			toAccount.setAmount(toAccount.getAmount() + t.getAmount());
			fromAccount.setAmount(fromAccount.getAmount() - t.getAmount());
			
			accountService.merge(toAccount);
			accountService.merge(fromAccount);
			
			persist(t);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
