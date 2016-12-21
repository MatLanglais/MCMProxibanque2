package com.mcmproxibanque.model;

import javax.persistence.Entity;

/**
 * <b>Mod�le CurrentAccount.</b>
 * <p>
 * Mod�le utilis� pour d�finir le compte courant d'un {@link Customer}. H�rite
 * de {@link Account}. <br />
 * Ce mod�le est caract�ris� par :
 * <ul>
 * <li>overdraft : autorisation de d�couvert</li>
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
