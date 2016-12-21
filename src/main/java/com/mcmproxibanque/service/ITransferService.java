package com.mcmproxibanque.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mcmproxibanque.model.Account;
import com.mcmproxibanque.model.Transfer;
/**
 * <b>Service ITransferService</b>
 * <p>
 * Implémentation de l'interface {@link IService}.
 * </p>
 * 
 * @author Claire Steinmacher
 * @author Mathilde Terrioux
 * @author Mathieu Langlais
 * 
 * @version 1
 * 
 */
@Component
public interface ITransferService extends IService<Transfer>{

	/**
	 * @param toAccountId - Id du Compte à débiter
	 * @param fromAccountId - Id du Compte à créditer
	 * @return - boolean renvoyant si le virement à été effectué ou non
	 */
	boolean doTransfer(Transfer t);
	List<Transfer> getTransfersOfCurrentWeek();
	List<Transfer> getTransfersOfCurrentMonth();

}