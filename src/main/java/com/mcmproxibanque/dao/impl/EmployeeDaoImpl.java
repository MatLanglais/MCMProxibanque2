package com.mcmproxibanque.dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mcmproxibanque.dao.interfaces.IEmployeeDao;
import com.mcmproxibanque.model.Employee;

@Component
@Transactional
public class EmployeeDaoImpl extends DaoImpl<Employee> implements IEmployeeDao {

}
