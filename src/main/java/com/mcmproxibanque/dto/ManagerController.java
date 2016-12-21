package com.mcmproxibanque.dto;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcmproxibanque.model.Manager;
import com.mcmproxibanque.service.ManagerService;

@ManagedBean
@Component
@SessionScoped
public class ManagerController {

	private Manager manager = new Manager();

	@Autowired
	ManagerService managerService;

	public String loginManagerVerif() {
		boolean testvar = false;
		List<Manager> managers = new ArrayList<>();

		try {
			managers = managerService.findAll();
			for (Manager managerl : managers) {
				if ((manager.getLogin()).equals(managerl.getLogin())
						&& (manager.getPassword()).equals(managerl.getPassword())) {
					manager = managerl;
					HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
							.getSession(true);
					session.setAttribute("managersession", manager);
					testvar = true;
					return "/views/manager/listeConseillers.xhtml";
				}
				
			}
			if (!testvar) {
				return "/erreurlogin.xhtml";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "/erreurlogin.xhtml";
		}
		return "/erreurlogin.xhtml";
	}

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
