package com.mcmproxibanque.dao.interfaces;

import com.mcmproxibanque.dao.impl.AccountDaoImpl;
import com.mcmproxibanque.dao.impl.CustomerDaoImpl;
import com.mcmproxibanque.model.Customer;

/**
 * <b>Interface ICustomerDao.</b>
 * <p>
 * Interface permettant d'implementer l'interface {@link IDao}. Cette interface
 * est implémentée par la classe de DAO {@link CustomerDaoImpl}. <br />
 * 
 * @author Claire Steinmacher
 * @author Mathilde Terrioux
 * @author Mathieu Langlais
 * 
 * @version 1
 * 
 * @see {@link IDao}
 * @see {@link CustomerDaoImpl}
 * 
 */
public interface ICustomerDao extends IDao<Customer> {

}
