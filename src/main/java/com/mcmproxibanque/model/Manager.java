package com.mcmproxibanque.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
/**
 * <b>Mod�le Manager.</b>
 * <p>
 * Mod�le de base de l'advisor. H�rite de la classe {@link Employee}.
 * <br />
 * Ce mod�le est caract�ris� par :
 * <ul>
 * <li>advisors : {@link Collection} des {@link Advisor} du manager</li>
 * </ul>
 * 
 * @author Claire Steinmacher
 * @author Mathilde Terrioux
 * @author Mathieu Langlais
 * 
 * @version 1
 * 
 * @see {@link Employee}
 * 
 */
@Entity
public class Manager extends Employee {

	private static final long serialVersionUID = 1L;
	@OneToMany(cascade = { CascadeType.ALL })
	Collection<Advisor> advisors = new ArrayList<>();

	public Manager() {
	}

	// Getters & Setters
	public Collection<Advisor> getAdvisors() {
		return advisors;
	}

	public void setAdvisors(Collection<Advisor> advisors) {
		this.advisors = advisors;
	}

}
