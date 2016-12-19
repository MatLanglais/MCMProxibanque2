package com.mcmproxibanque.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mcmproxibanque.dao.impl.CustomerDaoImpl;
import com.mcmproxibanque.model.Account;
import com.mcmproxibanque.model.Address;
import com.mcmproxibanque.model.CurrentAccount;
import com.mcmproxibanque.model.Customer;
import com.mcmproxibanque.service.CustomerService;
import com.mcmproxibanque.service.IService;


public class MainTest {
	
	public static void main(String[] args) throws Exception {

		ApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/spring/applicationContext-db-mysql.xml");
		IService<Customer> customerService = context.getBean("customerService", CustomerService.class);
		
		Customer c = new Customer();
		Address a = new Address();
		a.setCity("Paris");
		a.setStreet("Avenue des Champs Elysees");
		a.setZipCode("75001");
		c.setAddress(a);
		c.setEmail("mathilde.therrioux@elysee.fr");
		c.setForename("Mathilde");
		c.setName("Therrioux");
//		Account cc = new CurrentAccount();
//		cc.setId(1L);
//		cc.setAmount((double) 500);
//		c.setCurrentAccount((CurrentAccount) cc);
		
		customerService.persist(c);
		System.out.println(c);
		System.out.println(customerService.findAll());
		
		
// Customer c = new Customer();
//		CustomerDaoImpl customerDao = context.getBean("customerDaoImpl", CustomerDaoImpl.class);
//		System.out.println(c);
//		
//		customerDao.persist(c);
		

	}
	
	

}
