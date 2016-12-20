package com.mcmproxibanque.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mcmproxibanque.model.Address;
import com.mcmproxibanque.model.Advisor;
import com.mcmproxibanque.model.CurrentAccount;
import com.mcmproxibanque.model.Customer;
import com.mcmproxibanque.model.Manager;
import com.mcmproxibanque.model.SavingAccount;
import com.mcmproxibanque.service.ManagerService;

public class MainTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/spring/applicationContext-*.xml");

		double savingAmount = 1000.5;
		double currentAmount = 10;
		String street = "3 rue Stephenson";
		String city = "Montigny";
		String zipCode = "78180";
		String email="client@gtm.fr";
		String phone = "0123456789";

		Customer c = new Customer();
		c.setForename("Quentin");
		c.setName("LeBrun");
		c.setAddress(new Address(street, city, zipCode));
		c.setEmail(email);
		c.setPhone(phone);

		SavingAccount savingAccount = new SavingAccount();
		savingAccount.setAmount(savingAmount);
		c.setSavingAccount(savingAccount);
		

		CurrentAccount currentAccount = new CurrentAccount();
		currentAccount.setAmount(currentAmount);
		c.setCurrentAccount(currentAccount);

		Customer c2 = new Customer();
		c2.setForename("Marc-Antoine");
		c2.setName("LeBlond");
		c2.setAddress(new Address(street, city, zipCode));
		c2.setEmail(email);
		c2.setPhone(phone);

		SavingAccount savingAccount2 =new SavingAccount();
		savingAccount2.setAmount(savingAmount);
		c2.setSavingAccount(savingAccount2);

		Advisor a = new Advisor();
		a.setForename("Nabila");
		a.setLogin("admin");
		a.setPassword("admin");
		a.getCustomers().add(c2);
		a.getCustomers().add(c);

		Customer c3 = new Customer();
		c3.setForename("Claire");
		c3.setName("SSSS");
		c3.setAddress(new Address(street, city, zipCode));
		c3.setEmail(email);
		c3.setPhone(phone);
		CurrentAccount currentAccount3 = new CurrentAccount();
		currentAccount3.setAmount(currentAmount);
		c3.setCurrentAccount(currentAccount3);

		Customer c4 = new Customer();
		c4.setForename("Mathieu");
		c4.setName("hhhe");
		c4.setAddress(new Address(street, city, zipCode));
		c4.setEmail(email);
		c4.setPhone(phone);
		SavingAccount savingAccount4 = new SavingAccount();
		savingAccount4.setAmount(savingAmount);
		c4.setSavingAccount(savingAccount4);
		
		Advisor a2 = new Advisor();
		a2.setForename("Mathilde");
		a2.setLogin("123");
		a2.setPassword("123");
		a2.getCustomers().add(c3);
		a2.getCustomers().add(c4);

		Manager m = new Manager();
		m.setForename("Yann");
		m.setLogin("abc");
		m.setPassword("abc");
		m.getAdvisors().add(a);
		m.getAdvisors().add(a2);

		ManagerService service = context.getBean("managerService", ManagerService.class);
		service.persist(m);

	}

}
