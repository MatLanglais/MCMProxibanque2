package com.mcmproxibanque.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mcmproxibanque.dao.interfaces.IAccountDao;
import com.mcmproxibanque.dao.interfaces.ITransferDao;
import com.mcmproxibanque.model.Transfer;
/**
 * <b>Implémentation TransferDaoImpl</b>
 * <p>
 * Implémentation de l'interface {@link ITransferDao}.
 * </p>
 * 
 * @author Claire Steinmacher
 * @author Mathilde Terrioux
 * @author Mathieu Langlais
 * 
 * @version 1
 * 

 * @see {@link ITransferDao}
 * 
 */
@Component
@Transactional
public class TransferDaoImpl extends DaoImpl<Transfer> implements ITransferDao {

	@PersistenceContext(unitName = "persistenceUnit")
	protected EntityManager entityManager;
	private int month = Calendar.getInstance().get(Calendar.MONTH)+1;
	private int year = Calendar.getInstance().get(Calendar.YEAR);
	private int week = Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);

	@Transactional(readOnly=true)
	@SuppressWarnings("unchecked")
	@Override
	public List<Transfer> findTransferOfCurrentMonth() {
		String query = "Select t from Transfer t where month = ?1 and year = ?2";
		List<Transfer> monthlyTransfers = getEntityManager()
				.createQuery(query).setParameter(1, month)
				.setParameter(2, year).getResultList();

		return monthlyTransfers;
	}
	
	@Transactional(readOnly=true)
	@SuppressWarnings("unchecked")
	@Override
	public List<Transfer> findTransferOfCurrentWeek() {
		String query = "Select t from Transfer t where week = ?1 and year = ?2";
		List<Transfer> weeklyTransfers = getEntityManager()
				.createQuery(query).setParameter(1, week)
				.setParameter(2, year).getResultList();
		return weeklyTransfers;
	}

}
