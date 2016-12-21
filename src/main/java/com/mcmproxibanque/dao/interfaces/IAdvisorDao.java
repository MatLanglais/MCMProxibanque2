package com.mcmproxibanque.dao.interfaces;

import com.mcmproxibanque.dao.impl.AccountDaoImpl;
import com.mcmproxibanque.dao.impl.AdvisorDaoImpl;
import com.mcmproxibanque.model.Advisor;

/**
 * <b>Interface IAdvisorDao</b>
 * <p>
 * Interface permettant d'implementer l'interface {@link IDao}. Cette interface
 * est implémentée par la classe de DAO {@link AdvisorDaoImpl}. </p>
 * 
 * @author Claire Steinmacher
 * @author Mathilde Terrioux
 * @author Mathieu Langlais
 * 
 * @version 1
 * 
 * @see {@link IDao}
 * @see {@link AdvisorDaoImpl}
 * 
 */
public interface IAdvisorDao extends IDao<Advisor> {

	Advisor findAdvisorByIdwithFetchedCustomers(long id);

	
}
