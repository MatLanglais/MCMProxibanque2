package com.mcmproxibanque.dao.impl;

import com.mcmproxibanque.model.Account;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mcmproxibanque.dao.interfaces.IAccountDao;
import com.mcmproxibanque.dao.interfaces.IDao;
/**
 * <b>Impl�mentation AccountDaoImpl</b>
 * <p>
 * Impl�mentation de l'interface {@link IAccountDao}.
 * </p>
 * 
 * @author Claire Steinmacher
 * @author Mathilde Terrioux
 * @author Mathieu Langlais
 * 
 * @version 1
 * 

 * @see {@link IAccountDao}
 * 
 */
@Component
@Transactional
public class AccountDaoImpl extends DaoImpl<Account> implements IAccountDao {

}
