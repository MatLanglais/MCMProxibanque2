package com.mcmproxibanque.dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mcmproxibanque.dao.interfaces.IAccountDao;
import com.mcmproxibanque.dao.interfaces.IEmployeeDao;
import com.mcmproxibanque.model.Employee;
/**
 * <b>Impl�mentation EmployeeDaoImpl</b>
 * <p>
 * Impl�mentation de l'interface {@link IEmployeeDao}.
 * </p>
 * 
 * @author Claire Steinmacher
 * @author Mathilde Terrioux
 * @author Mathieu Langlais
 * 
 * @version 1
 * 

 * @see {@link IEmployeeDao}
 * 
 */
@Component
@Transactional
public class EmployeeDaoImpl extends DaoImpl<Employee> implements IEmployeeDao {

}
