package com.mcmproxibanque.dao.impl;

import java.util.Collection;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mcmproxibanque.dao.interfaces.IAdvisorDao;
import com.mcmproxibanque.model.Advisor;
import com.mcmproxibanque.model.Customer;

@Component
@Transactional
public class AdvisorDaoImpl extends DaoImpl<Advisor> implements IAdvisorDao {

	

}
