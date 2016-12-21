package com.mcmproxibanque.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
/**
 * <b>Mod�le Advisor.</b>
 * <p>
 * Mod�le de base de l'advisor. Elle h�rite de la classe {@link Employee}.
 * <br />
 * Ce mod�le est caract�ris� par :
 * <ul>
 * <li>customers : {@link Collection} des {@link Customer} de l'advisor. </li>
 * </ul>
 * 
 * @author Claire Steinmacher
 * @author Mathilde Terrioux
 * @author Mathieu Langlais
 * 
 * @version 1
 * 
 * @See {@link Employee}
 * 
 */

@Entity
public class Advisor extends Employee {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@OneToMany(cascade = { CascadeType.ALL })
	Collection<Customer> customers = new ArrayList<>();

	public Advisor() {
	}

	public Collection<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Collection<Customer> customers) {
		this.customers = customers;
	}
}
