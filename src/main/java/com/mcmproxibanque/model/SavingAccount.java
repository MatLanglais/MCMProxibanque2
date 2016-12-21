package com.mcmproxibanque.model;

import javax.persistence.Entity;
/**
 * <b>Mod�le SavingAccount.</b>
 * <p>
 * Mod�le utilis� pour d�finir le compte �pargne d'un {@link Customer}. H�rite de {@link Account}.
 * <br />
 * Ce mod�le est caract�ris� par :
 * <ul>
 * <li>rate : taux d'�pargne </li>
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
