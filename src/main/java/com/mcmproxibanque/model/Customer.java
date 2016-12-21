package com.mcmproxibanque.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Customer implements Serializable {

	/**
	 * <b>Modèle Customer.</b>
	 * <p>
	 * Modèle de base du Customer. <br />
	 * Ce modèle est caractérisé par :
	 * <ul>
	 * <li>id : id générée pour la base de donnée</li>
	 * <li>name : nom du customer</li>
	 * <li>forename : prénom du customer</li>
	 * <li>address : {@link Address} du customer</li>
	 * <li>email : email du customer</li>
	 * <li>phone : téléphone du customer</li>
	 * </ul>
	 * 
	 * @author Claire Steinmacher
	 * @author Mathilde Terrioux
	 * @author Mathieu Langlais
	 * 
	 * @version 1
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	String name;
	String forename;
	@Embedded
	Address address = new Address();
	String email;
	String phone;

	@OneToOne(cascade = { CascadeType.ALL })
	SavingAccount savingAccount;
	@OneToOne(cascade = { CascadeType.ALL })
	CurrentAccount currentAccount;

	public Customer() {
	}

	// Getters & Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getForename() {
		return forename;
	}

	public void setForename(String forename) {
		this.forename = forename;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public SavingAccount getSavingAccount() {
		return savingAccount;
	}

	public void setSavingAccount(SavingAccount savingAccount) {
		this.savingAccount = savingAccount;
	}

	public CurrentAccount getCurrentAccount() {
		return currentAccount;
	}

	public void setCurrentAccount(CurrentAccount currentAccount) {
		this.currentAccount = currentAccount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
