package com.mcmproxibanque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcmproxibanque.model.Advisor;

@Component
public class AdvisorService implements IService<Advisor> {

	@Autowired
	
	
	@Override
	public void persist(Advisor e) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void merge(Advisor e) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Object id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Advisor findById(Object id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Advisor> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
