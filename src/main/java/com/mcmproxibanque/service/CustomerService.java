package com.mcmproxibanque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcmproxibanque.dao.interfaces.ICustomerDao;
import com.mcmproxibanque.model.Account;
import com.mcmproxibanque.model.Customer;
/**
 * <b>Service CustomerService</b>
 * <p>
 * Implémentation de l'interface {@link IService} pour {@link Customer}. Elle étend la classe {@link ServiceImpl}.
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
public class CustomerService extends ServiceImpl<Customer> implements IService<Customer> {

	@Autowired
	ICustomerDao customerDaoImpl;

	@Override
	public void persist(Customer e) throws Exception {
		customerDaoImpl.persist(e);
	}

	@Override
	public void merge(Customer e) throws Exception {
		customerDaoImpl.merge(e);
	}

	@Override
	public void remove(Object id) throws Exception {
		customerDaoImpl.remove(id);
	}

	@Override
	public Customer findById(Object id) throws Exception {
		return customerDaoImpl.findById(id);
	}

	@Override
	public List<Customer> findAll() throws Exception {
		return customerDaoImpl.findAll();
	}

}
