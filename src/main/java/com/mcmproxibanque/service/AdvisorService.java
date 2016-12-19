package com.mcmproxibanque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.mcmproxibanque.dao.interfaces.IAdvisorDao;
import com.mcmproxibanque.dao.interfaces.IEmployeeDao;
import com.mcmproxibanque.model.Advisor;
import com.mcmproxibanque.model.Employee;

@Component("advisorService")
public class AdvisorService implements IService<Advisor> {

//	@Autowired
//	@Qualifier("advisorDaoImpl")
	IAdvisorDao advisorDaoImpl;
	
	@Override
	public void persist(Advisor e) throws Exception {
		advisorDaoImpl.persist(e);
	}

	@Override
	public void merge(Advisor e) throws Exception {
		advisorDaoImpl.merge(e);
	}

	@Override
	public void remove(Object id) throws Exception {
		advisorDaoImpl.remove(id);
	}

	@Override
	public Advisor findById(Object id) throws Exception {
		Advisor advisor = (Advisor) advisorDaoImpl.findById(id);
		return advisor;
	}

	@Override
	public List<Advisor> findAll() throws Exception {
		List<Advisor> listAdvisor = advisorDaoImpl.findAll();
		return listAdvisor;
	}

}
