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
		this.manager = manager;
	}

	public ManagerController() {
	}
	
		
}
