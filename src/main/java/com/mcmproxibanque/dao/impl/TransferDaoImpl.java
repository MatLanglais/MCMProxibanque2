package com.mcmproxibanque.dao.impl;

import org.springframework.stereotype.Component;

import com.mcmproxibanque.dao.interfaces.ITransferDao;
import com.mcmproxibanque.model.Transfer;

@Component
public class TransferDaoImpl extends DaoImpl<Transfer> implements ITransferDao {

}
