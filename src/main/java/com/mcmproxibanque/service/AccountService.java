package com.mcmproxibanque.service;

import java.util.List;

import org.primefaces.model.chart.BarChartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcmproxibanque.dao.interfaces.IAccountDao;
import com.mcmproxibanque.model.Account;
/**
 * <b>Service AccountService</b>
 * <p>
 * Impl�mentation de l'interface {@link IService} pour {@link Account} .
 * </p>
 * 
 * @author Claire Steinmacher
 * @author Mathilde Terrioux
 * @author Mathieu Langlais
 * 
 * @version 1
 * 
 */
@Component
public class AccountService implements IService<Account> {
	
	@Autowired
	IAccountDao accountDaoImpl;

	@Override
	public void persist(Account e) throws Exception {
		accountDaoImpl.persist(e);
		
	}

	@Override
	public void merge(Account e) throws Exception {
		accountDaoImpl.merge(e);
		
	}

	@Override
	public void remove(Object id) throws Exception {
		accountDaoImpl.remove(id);
		
	}

	@Override
	public Account findById(Object id) throws Exception {
		Account account = accountDaoImpl.findById(id);
		return account;
	}

	@Override
	public List<Account> findAll() throws Exception {
		List<Account> listAccount = accountDaoImpl.findAll();
		return listAccount;
	}	

}
