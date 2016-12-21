package com.mcmproxibanque.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
/**
 * <b>Mod�le TransferDate.</b>
 * <p>
 * Mod�le utilis� pour d�finir la date d'un {@link Transfer}
 * <br />
 * Ce mod�le est caract�ris� par :
 * <ul>
 * <li>day : jour </li>
 * <li>week : num�ro de la semaine</li>
 * <li>month : mois</li>
 * <li>year : ann�e</li>
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
@Embeddable
public class TransferDate implements Serializable{

	private static final long serialVersionUID = 1L;
	private long day;
	private long week;
	private long month;
	private long year;

	public TransferDate() {
	}

	public TransferDate(long day, long week, long month, long year) {
		super();
		this.day = day;
		this.week = week;
		this.month = month;
		this.year = year;
	}

	public long getDay() {
		return day;
	}

	public void setDay(long day) {
		this.day = day;
	}

	public long getWeek() {
		return week;
	}

	public void setWeek(long week) {
		this.week = week;
	}

	public long getMonth() {
		return month;
	}

	public void setMonth(long month) {
		this.month = month;
	}

	public long getYear() {
		return year;
	}

	public void setYear(long year) {
		this.year = year;
	}

}
