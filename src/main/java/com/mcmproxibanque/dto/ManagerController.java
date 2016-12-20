package com.mcmproxibanque.dto;

import java.util.Collection;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mcmproxibanque.model.Advisor;
import com.mcmproxibanque.model.Customer;
import com.mcmproxibanque.model.Manager;

@ManagedBean
@Component
public class ManagerController {

	private Manager manager;

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public ManagerController() {
	}
	
		
}
