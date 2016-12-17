package com.mcmproxibanque.dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mcmproxibanque.dao.interfaces.ICustomerDao;
import com.mcmproxibanque.model.Customer;

@Component
@Transactional
public class CustomerDaoImpl extends DaoImpl<Customer> implements ICustomerDao {

}
