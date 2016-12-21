package com.mcmproxibanque.dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mcmproxibanque.dao.interfaces.IAccountDao;
import com.mcmproxibanque.dao.interfaces.ICustomerDao;
import com.mcmproxibanque.model.Customer;
/**
 * <b>Implémentation CustomerDaoImpl</b>
 * <p>
 * Implémentation de l'interface {@link ICustomerDao}.
 * </p>
 * 
 * @author Claire Steinmacher
 * @author Mathilde Terrioux
 * @author Mathieu Langlais
 * 
 * @version 1
 * 

 * @see {@link ICustomerDao}
 * 
 */
@Component
@Transactional
public class CustomerDaoImpl extends DaoImpl<Customer> implements ICustomerDao {

}
