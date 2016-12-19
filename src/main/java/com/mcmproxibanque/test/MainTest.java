package com.mcmproxibanque.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.mcmproxibanque.model.Advisor;
import com.mcmproxibanque.model.CurrentAccount;
import com.mcmproxibanque.model.Customer;
import com.mcmproxibanque.model.Manager;
import com.mcmproxibanque.model.SavingAccount;
import com.mcmproxibanque.service.ManagerService;

public class MainTest {

	public static void main(String[] args) throws Exception {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/spring/applicationContext-*.xml");

		double savingAmount = 1000.5;
		double currentAmount = 10;

		Customer c = new Customer();
		c.setForename("Quentin");
		c.setName("LeBrun");
		SavingAccount savingAccount = new SavingAccount();
		savingAccount.setAmount(savingAmount);
		c.setSavingAccount(savingAccount);
		CurrentAccount currentAccount = new CurrentAccount();
		currentAccount.setAmount(currentAmount);
		c.setCurrentAccount(currentAccount);
		
		Customer c2 = new Customer();
		c2.setForename("Marc-Antoine");
		c2.setName("LeBlond");
		SavingAccount savingAccount2 =new SavingAccount();
		savingAccount2.setAmount(savingAmount);
		c2.setSavingAccount(savingAccount2);
		CurrentAccount currentAccount2 = new CurrentAccount();
		currentAccount2.setAmount(currentAmount);
		c2.setCurrentAccount(currentAccount2);
		
		Advisor a = new Advisor();
		a.setForename("Nabila");
		a.getCustomers().add(c2);
		a.getCustomers().add(c);

		Customer c3 = new Customer();
		c3.setForename("Claire");
		SavingAccount savingAccount3 =new SavingAccount();
		savingAccount3.setAmount(savingAmount);
		c3.setSavingAccount(savingAccount3);
		CurrentAccount currentAccount3 = new CurrentAccount();
		currentAccount3.setAmount(currentAmount);
		c3.setCurrentAccount(currentAccount3);
		
		Customer c4 = new Customer();
		c4.setForename("Mathieu");
		SavingAccount savingAccount4 =new SavingAccount();
		savingAccount4.setAmount(savingAmount);
		c4.setSavingAccount(savingAccount4);
		CurrentAccount currentAccount4 = new CurrentAccount();
		currentAccount4.setAmount(currentAmount);
		c4.setCurrentAccount(currentAccount4);
		
		Advisor a2 = new Advisor();
		a2.setForename("Mathilde");
		a2.getCustomers().add(c3);
		a2.getCustomers().add(c4);

		Manager m = new Manager();
		m.setForename("Yann");
		m.getAdvisors().add(a);
		m.getAdvisors().add(a2);

		ManagerService service = context.getBean("managerService", ManagerService.class);
		service.persist(m);

	}

}
