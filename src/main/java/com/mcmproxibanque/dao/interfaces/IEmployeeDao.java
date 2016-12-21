package com.mcmproxibanque.dao.interfaces;

import com.mcmproxibanque.dao.impl.AccountDaoImpl;
import com.mcmproxibanque.dao.impl.EmployeeDaoImpl;
import com.mcmproxibanque.model.Employee;

/**
 * <b>Interface IEmployeeDao.</b>
 * <p>
 * Interface permettant d'implementer l'interface {@link IDao}. Cette interface
 * est implémentée par la classe de DAO {@link EmployeeDaoImpl}. <br />
 * 
 * @author Claire Steinmacher
 * @author Mathilde Terrioux
 * @author Mathieu Langlais
 * 
 * @version 1
 * 
 * @see {@link IDao}
 * @see {@link EmployeeDaoImpl}
 * 
 */
public interface IEmployeeDao extends IDao<Employee> {

}
