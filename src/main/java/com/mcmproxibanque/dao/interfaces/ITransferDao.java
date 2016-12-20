package com.mcmproxibanque.dao.interfaces;

import java.util.List;

import com.mcmproxibanque.model.Transfer;


public interface ITransferDao extends IDao<Transfer> {
	
	List<Transfer> findTransferOfCurrentMonth();
	List<Transfer> findTransferOfCurrentWeek();
}
