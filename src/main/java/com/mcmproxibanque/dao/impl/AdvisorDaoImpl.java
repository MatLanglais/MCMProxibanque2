package com.mcmproxibanque.dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mcmproxibanque.dao.interfaces.IAdvisorDao;
import com.mcmproxibanque.model.Advisor;

@Component
@Transactional
public class AdvisorDaoImpl extends DaoImpl<Advisor> implements IAdvisorDao{

}
