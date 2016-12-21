package com.mcmproxibanque.model;

import javax.persistence.Entity;
/**
 * <b>Modèle SavingAccount.</b>
 * <p>
 * Modèle utilisé pour définir le compte épargne d'un {@link Customer}. Hérite de {@link Account}.
 * <br />
 * Ce modèle est caractérisé par :
 * <ul>
 * <li>rate : taux d'épargne </li>
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
public class SavingAccount extends Account {

	private static final long serialVersionUID = 1L;
	double rate = 0.3;

	public SavingAccount() {
	}

	// Getters & Setters
	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

}
