package com.mcmproxibanque.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
/**
 * <b>Modèle Advisor.</b>
 * <p>
 * Modèle de base de l'advisor. Elle hérite de la classe {@link Employee}.
 * <br />
 * Ce modèle est caractérisé par :
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
