package com.mcmproxibanque.dao.interfaces;

import com.mcmproxibanque.dao.impl.AccountDaoImpl;
import com.mcmproxibanque.model.Account;

/**
 * <b>Interface IAccountDao.</b>
 * <p>
 * Interface permettant d'implementer l'interface {@link IDao}. Cette interface
 * est implémentée par la classe de DAO {@link AccountDaoImpl}. </p>
 * 
 * @author Claire Steinmacher
 * @author Mathilde Terrioux
 * @author Mathieu Langlais
 * 
 * @version 1
 * 
 * @see {@link IDao}
 * @see {@link AccountDaoImpl}
 * 
 */
public interface IAccountDao extends IDao<Account> {

}
