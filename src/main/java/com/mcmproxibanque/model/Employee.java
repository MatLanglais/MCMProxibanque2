package com.mcmproxibanque.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
/**
 * <b>Mod�le Employee</b>
 * <p>
 * Mod�le de base des employ�s de la banque. Ce mod�le est h�rit� par {@link Advisor} et {@link Manager}.
 * <br />
 * Ce mod�le est caract�ris� par :
 * <ul>
 * <li>login : login de l'employee </li>
 * <li>password : password de l'employee</li>
 * <li>name : nom de l'employee</li>
 * <li>forename : pr�nom de l'employee
 * </ul>
 * 
 * @author Claire Steinmacher
 * @author Mathilde Terrioux
 * @author Mathieu Langlais
 * 
 * @version 1
 * 
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
	String login;
	String password;
	String name;
	String forename;
	
	// Getters & Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
