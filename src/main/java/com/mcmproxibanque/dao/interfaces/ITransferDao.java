package com.mcmproxibanque.dao.interfaces;

import java.util.List;

import com.mcmproxibanque.dao.impl.TransferDaoImpl;
import com.mcmproxibanque.model.Transfer;

/**
 * <b>Interface ITransferDao.</b>
 * <p>
 * Interface permettant d'implementer l'interface {@link IDao}. Cette interface
 * est implémentée par la classe de DAO {@link TransferDaoImpl}. <br />
 * 
 * @author Claire Steinmacher
 * @author Mathilde Terrioux
 * @author Mathieu Langlais
 * 
 * @version 1
 * 
 * @see {@link IDao}
 * @see {@link TransferDaoImpl}
 * 
 */
public interface ITransferDao extends IDao<Transfer> {
	
	/**
	 * @return Liste des {@link Transfer} du mois
	 */
	List<Transfer> findTransferOfCurrentMonth();
	/**
	 * @return Liste des {@link Transfer} de la semaine
	 */
	List<Transfer> findTransferOfCurrentWeek();
}
