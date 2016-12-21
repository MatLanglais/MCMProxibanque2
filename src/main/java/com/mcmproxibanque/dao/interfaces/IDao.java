package com.mcmproxibanque.dao.interfaces;

import java.util.List;

/**
 * <b>Interface IDao.</b>
 * <p>
 * Interface g�n�raliste de la DAO permettant d'ajouter les m�thodes � toutes
 * les classe impl�mentant cette interface
 * </p>
 * 
 * @author Claire Steinmacher
 * @author Mathilde Terrioux
 * @author Mathieu Langlais
 * 
 * @version 1
 * 
 */
public interface IDao<E> {

	/**
	 * @param e - Objet a persist�
	 * @throws Exception
	 */
	void persist(E e) throws Exception;

	/**
	 * @param e - Objet a mettre � jour
	 * @throws Exception
	 */
	void merge(E e) throws Exception;

	/**
	 * @param id - id de l'objet � supprimer
	 * @throws Exception
	 */
	void remove(Object id) throws Exception;

	/**
	 * @param id - Objet de l'id � trouver en base de donn�e
	 * @return Objet trouv� en base de donn�e
	 * @throws Exception
	 */
	E findById(Object id) throws Exception;

	/**
	 * @return {@link List} d'objet trouv� en base de donn�e
	 * @throws Exception
	 */
	List<E> findAll() throws Exception;

	/**
	 * @return nombre d'entr�e
	 * @throws Exception
	 */
	long count() throws Exception;

}
