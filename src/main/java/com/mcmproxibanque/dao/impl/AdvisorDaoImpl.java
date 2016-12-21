package com.mcmproxibanque.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mcmproxibanque.dao.interfaces.IAccountDao;
import com.mcmproxibanque.dao.interfaces.IAdvisorDao;
import com.mcmproxibanque.model.Advisor;
/**
 * <b>Implémentation AdvisorDaoImpl</b>
 * <p>
 * Implémentation de l'interface {@link IAdvisorDao}.
 * </p>
 * 
 * @author Claire Steinmacher
 * @author Mathilde Terrioux
 * @author Mathieu Langlais
 * 
 * @version 1
 * 

 * @see {@link IAdvisorDao}
 * 
 */
@Component
@Transactional
public class AdvisorDaoImpl extends DaoImpl<Advisor> implements IAdvisorDao {

	@PersistenceContext(unitName = "persistenceUnit")
	protected EntityManager entityManager;

	@Transactional
	@Override
	public Advisor findAdvisorByIdwithFetchedCustomers(long id) {
		Advisor advisor = (Advisor) getEntityManager()
				.createQuery("from Advisor a join fetch a.customers where a.id = " + id).getSingleResult();
		return advisor;
	}

}
