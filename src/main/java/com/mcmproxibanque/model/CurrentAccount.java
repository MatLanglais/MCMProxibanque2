package com.mcmproxibanque.model;

import javax.persistence.Entity;

/**
 * <b>Modèle CurrentAccount.</b>
 * <p>
 * Modèle utilisé pour définir le compte courant d'un {@link Customer}. Hérite
 * de {@link Account}. <br />
 * Ce modèle est caractérisé par :
 * <ul>
 * <li>overdraft : autorisation de découvert</li>
 * </ul>
 * 
 * @author Claire Steinmacher
 * @author Mathilde Terrioux
 * @author Mathieu Langlais
 * 
 * @version 1
 * 
 * @see {@link Account}
 * 
 */
@Entity
public class CurrentAccount extends Account {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	double overdraft = 1000;

	public CurrentAccount() {
	}

	// Getters & Setters
	public Double getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(Double overdraft) {
		this.overdraft = overdraft;
	}

}
