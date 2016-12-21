package com.mcmproxibanque.dao.interfaces;

import java.util.List;

/**
 * <b>Interface IDao.</b>
 * <p>
 * Interface généraliste de la DAO permettant d'ajouter les méthodes à toutes
 * les classe implémentant cette interface
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
	 * @param e - Objet a persisté
	 * @throws Exception
	 */
	void persist(E e) throws Exception;

	/**
	 * @param e - Objet a mettre à jour
	 * @throws Exception
	 */
	void merge(E e) throws Exception;

	/**
	 * @param id - id de l'objet à supprimer
	 * @throws Exception
	 */
	void remove(Object id) throws Exception;

	/**
	 * @param id - Objet de l'id à trouver en base de donnée
	 * @return Objet trouvé en base de donnée
	 * @throws Exception
	 */
	E findById(Object id) throws Exception;

	/**
	 * @return {@link List} d'objet trouvé en base de donnée
	 * @throws Exception
	 */
	List<E> findAll() throws Exception;

	/**
	 * @return nombre d'entrée
	 * @throws Exception
	 */
	long count() throws Exception;

}
