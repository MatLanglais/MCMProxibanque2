package com.mcmproxibanque.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mcmproxibanque.dao.impl.CustomerDaoImpl;
import com.mcmproxibanque.model.Customer;


public class MainTest {
	
	public static void main(String[] args) throws Exception {

		ApplicationContext context = new AnnotationConfigApplicationContext(com.mcmproxibanque.config.MCMConfig.class);
		
		
// Customer c = new Customer();
//		CustomerDaoImpl customerDao = context.getBean("customerDaoImpl", CustomerDaoImpl.class);
//		System.out.println(c);
//		
//		customerDao.persist(c);
		

	}
	
	

}
