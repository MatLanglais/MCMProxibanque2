package com.mcmproxibanque.dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mcmproxibanque.dao.interfaces.IManagerDao;
import com.mcmproxibanque.model.Manager;

@Component
@Transactional
public class ManagerDaoImpl extends DaoImpl<Manager> implements IManagerDao{

}
