package com.mcmproxibanque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.mcmproxibanque.dao.interfaces.IAdvisorDao;
import com.mcmproxibanque.model.Advisor;

@Component
public class AdvisorService implements IService<Advisor> {

	@Autowired
//	@Qualifier("advisorDaoImpl")
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

}
