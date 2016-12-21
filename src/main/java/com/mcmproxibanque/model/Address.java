package com.mcmproxibanque.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
/**
 * <b>Modèle address.</b>
 * <p>
 * Ce modèle est utilisé par le {@link Customer} (embedded).
 * <br />
 * Ce modèle est caractérisé par :
 * <ul>
 * <li>street : numéro et rue du {@link Customer} </li>
 * <li>zipCode : code postal du {@link Customer}</li>
 * <li>city : ville du {@link Customer}</li>
 * </ul>
 * 
 * @author Claire Steinmacher
 * @author Mathilde Terrioux
 * @author Mathieu Langlais
 * 
 * @version 1
 * 
 */

@Embeddable
public class Address implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String street;
	String city;
	String zipCode;

	public Address() {
	}

	public Address(String street, String city, String zipCode) {
		this.street = street;
		this.city = city;
		this.zipCode = zipCode;
	}

	// Getters & Setters
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	
}
