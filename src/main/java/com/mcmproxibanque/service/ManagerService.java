package com.mcmproxibanque.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcmproxibanque.dao.interfaces.IManagerDao;
import com.mcmproxibanque.model.Advisor;
import com.mcmproxibanque.model.Customer;
import com.mcmproxibanque.model.Manager;

@Component
public class ManagerService extends ServiceImpl<Manager> implements IService<Manager> {

	@Autowired
	IManagerDao managerDaoImpl;
	
	@Override
	public void persist(Manager e) throws Exception {
		managerDaoImpl.persist(e);
	}

	@Override
	public void merge(Manager e) throws Exception {
		managerDaoImpl.merge(e);
	}

	@Override
	public void remove(Object id) throws Exception {
		managerDaoImpl.remove(id);
	}

	@Override
	public Manager findById(Object id) throws Exception {
		return managerDaoImpl.findById(id);
	}

	@Override
	public List<Manager> findAll() throws Exception {
		return managerDaoImpl.findAll();
	}
	
	

}
