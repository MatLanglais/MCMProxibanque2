package com.mcmproxibanque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcmproxibanque.dao.interfaces.IEmployeeDao;
import com.mcmproxibanque.model.Advisor;
import com.mcmproxibanque.model.Employee;

@Component
public class AdvisorService implements IService<Advisor> {

	@Autowired
	IEmployeeDao employeeDaoImpl;
	
	@Override
	public void persist(Advisor e) throws Exception {
		employeeDaoImpl.persist(e);
	}

	@Override
	public void merge(Advisor e) throws Exception {
		employeeDaoImpl.merge(e);
	}

	@Override
	public void remove(Object id) throws Exception {
		employeeDaoImpl.remove(id);
	}

	@Override
	public Advisor findById(Object id) throws Exception {
		Advisor advisor = (Advisor) employeeDaoImpl.findById(id);
		return advisor;
	}

	@Override
	public List<Advisor> findAll() throws Exception {
		List<Employee> listAdvisor = employeeDaoImpl.findAll();
		return null;
	}

}
