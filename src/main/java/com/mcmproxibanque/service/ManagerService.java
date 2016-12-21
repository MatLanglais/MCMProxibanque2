package com.mcmproxibanque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcmproxibanque.dao.interfaces.IManagerDao;
import com.mcmproxibanque.model.Account;
import com.mcmproxibanque.model.Manager;
/**
 * <b>Service ManagerService</b>
 * <p>
 * Implémentation de l'interface {@link IService} pour {@link Manager}. Elle étend la classe {@link ServiceImpl}.
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
