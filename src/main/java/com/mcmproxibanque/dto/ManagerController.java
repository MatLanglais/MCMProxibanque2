package com.mcmproxibanque.dto;

import javax.faces.bean.ManagedBean;

import org.springframework.stereotype.Component;

import com.mcmproxibanque.model.Manager;

@ManagedBean
@Component
public class ManagerController {

	private Manager manager;

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		manager.setName(manager.getName().trim());
		manager.setForename(manager.getForename().trim());
		manager.setLogin(manager.getLogin().trim());
		manager.setPassword(manager.getPassword().trim());

		this.manager = manager;
	}

	public ManagerController() {
	}

}
