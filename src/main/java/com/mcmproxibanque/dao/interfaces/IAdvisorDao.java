package com.mcmproxibanque.dao.interfaces;

import com.mcmproxibanque.model.Advisor;


public interface IAdvisorDao extends IDao<Advisor> {

	Advisor findAdvisorByIdwithFetchedCustomers(long id);

	
}
