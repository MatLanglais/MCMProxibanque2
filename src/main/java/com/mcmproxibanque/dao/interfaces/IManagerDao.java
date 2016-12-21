package com.mcmproxibanque.dao.interfaces;

import com.mcmproxibanque.dao.impl.EmployeeDaoImpl;
import com.mcmproxibanque.dao.impl.ManagerDaoImpl;
import com.mcmproxibanque.model.Manager;

/**
 * <b>Interface IManagerDao.</b>
 * <p>
 * Interface permettant d'implementer l'interface {@link IDao}. Cette interface
 * est implémentée par la classe de DAO {@link ManagerDaoImpl}. <br />
 * 
 * @author Claire Steinmacher
 * @author Mathilde Terrioux
 * @author Mathieu Langlais
 * 
 * @version 1
 * 
 * @see {@link IDao}
 * @see {@link ManagerDaoImpl}
 * 
 */
public interface IManagerDao extends IDao<Manager> {

	
}
