package com.mcmproxibanque.dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mcmproxibanque.dao.interfaces.IAccountDao;
import com.mcmproxibanque.dao.interfaces.IManagerDao;
import com.mcmproxibanque.model.Manager;
/**
 * <b>Implémentation ManagerDaoImpl</b>
 * <p>
 * Implémentation de l'interface {@link IManagerDao}.
 * </p>
 * 
 * @author Claire Steinmacher
 * @author Mathilde Terrioux
 * @author Mathieu Langlais
 * 
 * @version 1
 * 

 * @see {@link IManagerDao}
 * 
 */
@Component
@Transactional
public class ManagerDaoImpl extends DaoImpl<Manager> implements IManagerDao{

}
