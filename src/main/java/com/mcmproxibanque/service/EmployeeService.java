package com.mcmproxibanque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcmproxibanque.dao.interfaces.IEmployeeDao;
import com.mcmproxibanque.model.Account;
import com.mcmproxibanque.model.Employee;
/**
 * <b>Service EmployeeService</b>
 * <p>
 * Implémentation de l'interface {@link IService} pour {@link Employee} .
 * </p>
 * 
 * @author Claire Steinmacher
 * @author Mathilde Terrioux
 * @author Mathieu Langlais
 * 
 * @version 1
 * 
 */
@Component
public class EmployeeService implements IService<Employee> {

	@Autowired
	IEmployeeDao employeeDaoImpl;
	
	@Override
	public void persist(Employee e) throws Exception {
		employeeDaoImpl.persist(e);
	}

	@Override
	public void merge(Employee e) throws Exception {
		employeeDaoImpl.merge(e);
	}

	@Override
	public void remove(Object id) throws Exception {
		employeeDaoImpl.remove(id);
	}

	@Override
	public Employee findById(Object id) throws Exception {
		Employee employee = employeeDaoImpl.findById(id);
		return employee;
		}

	@Override
	public List<Employee> findAll() throws Exception {
		List<Employee> listEmployee = employeeDaoImpl.findAll();
		return listEmployee;
		}
}
