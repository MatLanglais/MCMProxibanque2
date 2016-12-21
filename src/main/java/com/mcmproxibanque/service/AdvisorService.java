package com.mcmproxibanque.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcmproxibanque.dao.interfaces.IAdvisorDao;
import com.mcmproxibanque.model.Account;
import com.mcmproxibanque.model.Advisor;
import com.mcmproxibanque.model.Customer;
/**
 * <b>Service AdvisorService</b>
 * <p>
 * Implémentation de l'interface {@link IService} pour {@link Advisor} .
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
public class AdvisorService implements IService<Advisor> {

	@Autowired
	IAdvisorDao advisorDao;

	@Override
	public void persist(Advisor e) throws Exception {
		advisorDao.persist(e);
	}

	@Override
	public void merge(Advisor e) throws Exception {
		advisorDao.merge(e);
	}

	@Override
	public void remove(Object id) throws Exception {
		advisorDao.remove(id);
	}

	@Override
	public Advisor findById(Object id) throws Exception {
		Advisor advisor = (Advisor) advisorDao.findById(id);
		return advisor;
	}

	@Override
	public List<Advisor> findAll() throws Exception {
		List<Advisor> listAdvisor = advisorDao.findAll();
		return listAdvisor;
	}

	public Collection<Customer> getCustomersOfAdvisor(long id) {
		Advisor advisor = advisorDao.findAdvisorByIdwithFetchedCustomers(id);
		Collection<Customer> customers = advisor.getCustomers();
		return customers;
	}

}
