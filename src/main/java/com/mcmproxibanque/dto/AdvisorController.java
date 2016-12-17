package com.mcmproxibanque.dto;

import javax.faces.bean.ManagedBean;

import com.mcmproxibanque.model.Advisor;

@ManagedBean
public class AdvisorController {

	private Advisor advisor;

	public Advisor getAdvisor() {
		return advisor;
	}

	public void setAdvisor(Advisor advisor) {
		this.advisor = advisor;
	}

	public AdvisorController() {
	}
	
}
